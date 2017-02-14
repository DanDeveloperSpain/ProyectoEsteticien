/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Cita;
import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Tratamiento;
import com.fpmislata.domain.Venta;
import com.fpmislata.service.CitaServiceLocal;
import com.fpmislata.service.ClienteServiceLocal;
import com.fpmislata.service.ProductoServiceLocal;
import com.fpmislata.service.TratamientoServiceLocal;
import com.fpmislata.service.VentaServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielPerez
 */
@WebServlet(name = "EsteticienController",
        loadOnStartup = 1,
        urlPatterns = {"/AltaCliente",
            "/AltaTratamiento",
            "/ConcertarCita",
            "/EliminarCliente",
            "/EliminarTratamiento",
            "/ListarCitas",
            "/ListarClientes",
            "/ListarTratamientos",
            "/ModificarCliente",
            "/ModificarTratamiento",
            "/ListarProductos",
            "/ListarVentas",
            "/VentaProductos"})

public class EsteticienController extends HttpServlet {

    @EJB
    private VentaServiceLocal ventaService;

    @EJB
    private TratamientoServiceLocal tratamientoService;

    @EJB
    private ProductoServiceLocal productoService;

    @EJB
    private ClienteServiceLocal clienteService;

    @EJB
    private CitaServiceLocal citaService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        // Si la operacion es agregar cliente
        if (userPath.equals("/AltaCliente")) {
            altaCliente(request, response);

            // Si la operacion es agregr tratamiento
        } else if (userPath.equals("/AltaTratamiento")) {
            altaTratamiento(request, response);

            // Si la operacion es concertar cita
        } else if (userPath.equals("/ConcertarCita")) {
            concertarCita(request, response);

            // Si la operacion es eliminar cliente
        } else if (userPath.equals("/EliminarCliente")) {
            eliminarCliente(request, response);

            // Si la operacion es eliminar tratamiento
        } else if (userPath.equals("/EliminarTratamiento")) {
            eliminarTratamiento(request, response);

            // Si la operacion es listar citas
        } else if (userPath.equals("/ListarCitas")) {
            listarCitas(request, response);

            // Si la operacion es listar clientes
        } else if (userPath.equals("/ListarClientes")) {
            listarClientes(request, response);

            // Si la operacion es lostar tratamientos
        } else if (userPath.equals("/ListarTratamientos")) {
            listarTratamientos(request, response);

            // Si la operacion es modificar cliente
        } else if (userPath.equals("/ModificarCliente")) {
            modificarCliente(request, response);

            // Si la operacion es modificar tratamiento
        } else if (userPath.equals("/ModificarTratamiento")) {
            modificarTratamiento(request, response);

            // Si la operacion es listar productos
        } else if (userPath.equals("/ListarProductos")) {
            listarProductos(request, response);

            // Si la operacion es listar productos
        } else if (userPath.equals("/ListarVentas")) {
            listarVentas(request, response);

            // Si la operacion es venta productos
        } else if (userPath.equals("/VentaProductos")) {
            ventaProductos(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void altaCliente(HttpServletRequest request, HttpServletResponse response) {
        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String sexo = request.getParameter("sexo");
            String dni = request.getParameter("dni");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");

            Cliente clienteAnyadir = new Cliente();
            clienteAnyadir.setNombre(nombre);
            clienteAnyadir.setApellidos(apellidos);
            clienteAnyadir.setSexo(sexo);
            clienteAnyadir.setDni(dni);
            clienteAnyadir.setTelefono(telefono);
            clienteAnyadir.setEmail(email);

            try {
                clienteService.agregar(clienteAnyadir);
            } catch (Exception e) {
                //Informamos cualquier error
                e.printStackTrace();
            }

            List lista = clienteService.listarClientes();
            ArrayList<Cliente> clientes = new ArrayList<>(lista);
            request.getSession().setAttribute("listaClientes", clientes);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listarCliente.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void altaTratamiento(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1. Recuperamos los parametros
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            double duracion = Double.parseDouble(request.getParameter("duracion"));
            int sala = Integer.parseInt(request.getParameter("sala"));

            //2. Creamos el objeto Tratamiento
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setNombreTrat(nombre);
            tratamiento.setPrecioTrat(precio);
            tratamiento.setDuracionTrat(duracion);
            tratamiento.setSala(sala);

            try {
                tratamientoService.addTratamiento(tratamiento);
            } catch (Exception e) {
                //Informamos cualquier error
                e.printStackTrace();
            }

            // Volvemos a cargar la lista de personas
            List lista = tratamientoService.listaTratamientos();
            ArrayList<Tratamiento> tratamientos = new ArrayList<>(lista);
            request.getSession().setAttribute("tratamientos", tratamientos);

            //request.getRequestDispatcher("/listarTratamientos.jsp").forward(request, response);
            RequestDispatcher rd = request.getRequestDispatcher("/listarTratamientos.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void concertarCita(HttpServletRequest request, HttpServletResponse response) {
        //1. Recuperamos los parametros de la cita
        String fecha = request.getParameter("dia");
        String hora = request.getParameter("hora");
        int id_cliente = Integer.parseInt(request.getParameter("clienteChecked"));
        int id_trat = Integer.parseInt(request.getParameter("tratamientoChecked"));

        //2. Creamos el objeto Cita
        Cita cita = new Cita(fecha, hora);

        //3. Recuperamos el objeto Cliente y asignamos la cita
        Cliente cliente = new Cliente();
        cliente.setId(id_cliente);
        cliente = clienteService.mostrarUno(cliente);

        //Recuperamos el objeto tratamiento.
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(id_trat);
        tratamiento = tratamientoService.findTratamientoById(tratamiento);

        //4. Asignamos los valores
        cita.setCliente(cliente);
        cliente.getCitas().add(cita);

        cita.setTratamiento(tratamiento);
        tratamiento.getCitas().add(cita);

        try {
            citaService.addCita(cita);
            clienteService.modificar(cliente);
            tratamientoService.updateTratamiento(tratamiento);

            // Pasamos al RequestDispatcher la pagina a cargar
            String citaAsignada = "1";//funciona como un switch
            request.setAttribute("citaAsignada", citaAsignada);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            // Cargamos la pagina
            rd.forward(request, response);

        } catch (Exception e) {
            //Informamos cualquier error 
            e.printStackTrace();
        }
        //listarCitas(request, response);


        /*try {
            String accion = request.getParameter("accion");

            if (accion.equals("primero")) {

                try {
                    // Ejecutamos el metodo y obtenemos la lista de clientes y tratamientos
                    List lista = clienteService.listarClientes();
                    ArrayList<Cliente> listaCli = new ArrayList<>(lista);

                    List listatra = tratamientoService.listaTratamientos();
                    ArrayList<Tratamiento> listaTrat = new ArrayList<>(listatra);
                    // Asignamos al request el atributo lista 
                    request.getSession().setAttribute("listaCli", listaCli);
                    request.getSession().setAttribute("listaTrat", listaTrat);
                    // Pasamos al RequestDispatcher la pagina a cargar
                    RequestDispatcher rd = request.getRequestDispatcher("/seleccionCita.jsp");
                    // Cargamos la pagina
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (accion.equals("segundo")) {

                //Recogemos los datos para crear la cita
                int idCli = Integer.parseInt(request.getParameter("clienteChecked"));
                int idTrat = Integer.parseInt(request.getParameter("tratamientoChecked"));
                String dia = request.getParameter("dia");
                String hora = request.getParameter("hora");

                //2. Creamos el objeto Cita
                Cita cita = new Cita();
                cita.setIdCliente(idCli);
                cita.setIdTratamiento(idTrat);
                cita.setFecha(dia);
                cita.setHora(hora);

                try {
                    citaService.addCita(cita);
                } catch (Exception e) {
                    //Informamos cualquier error
                    e.printStackTrace();
                }

                // Pasamos al RequestDispatcher la pagina a cargar
                String citaAsignada = "1";//funciona como un switch
                request.setAttribute("citaAsignada", citaAsignada);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                // Cargamos la pagina
                rd.forward(request, response);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
        try {
            String[] clientesMarcados = request.getParameterValues("clienteChecked");
            if (clientesMarcados != null) {
                for (int i = 0; i < clientesMarcados.length; i++) {
                    int idCliente = Integer.parseInt(clientesMarcados[i]);
                    Cliente clienteABorrar = new Cliente();
                    clienteABorrar.setId(idCliente);
                    clienteService.borrar(clienteABorrar);
                }
            }
            List lista = clienteService.listarClientes();
            ArrayList<Cliente> clientes = new ArrayList<>(lista);
            request.getSession().setAttribute("listaClientes", clientes);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listarCliente.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarTratamiento(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1. Recuperamos los parametros
            String idTratamiento = request.getParameter("id");

            //2. Creamos el objeto Tratamiento
            int id = Integer.parseInt(idTratamiento);
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setId(id);

            try {
                //3. Eliminamos el tratamiento
                this.tratamientoService.deleteTratamiento(tratamiento);
            } catch (Exception e) {
                //Informamos cualquier error
                e.printStackTrace();
            }

            // Volvemos a cargar la lista de tratamientos
            List lista = tratamientoService.listaTratamientos();
            ArrayList<Tratamiento> tratamientos = new ArrayList<>(lista);
            request.getSession().setAttribute("tratamientos", tratamientos);

            RequestDispatcher rd = request.getRequestDispatcher("/listarTratamientos.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listarCitas(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Ejecutamos el metodo y obtenemos la lista 
            List listacitas = citaService.listCitas();

            // Asignamos al request el atributo lista
            ArrayList<Cita> listaArrayCita = new ArrayList<>(listacitas);
            request.getSession().setAttribute("citas", listaArrayCita);

            // Como podemos agregar citas necesitamos cargar los clientes y los tratamientos
            List listaClientes = clienteService.listarClientes();
            ArrayList<Cliente> listaArrayClientes = new ArrayList<>(listaClientes);
            request.getSession().setAttribute("clientes", listaArrayClientes);

            List listaTratamientos = tratamientoService.listaTratamientos();
            ArrayList<Tratamiento> listaArrayTratamientos = new ArrayList<>(listaTratamientos);
            request.getSession().setAttribute("tratamientos", listaArrayTratamientos);

            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarCitas.jsp"); // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            // Ejecutamos el metodo y obtenemos la lista
            ArrayList<Cita> listaCita = citaService.listaCitas();
            ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
            ArrayList<Tratamiento> listaTrat = new ArrayList<Tratamiento>();

            for (Cita cita : listaCita) {
                Cliente cli = new Cliente();
                cli.setId(cita.getIdCliente());
                Cliente cliente = clienteService.mostrarUno(cli);
                listaCli.add(cliente);
                //Cliente cliente= clienteService.muestraUnoId(cita.getIdCliente());
                Tratamiento tra = new Tratamiento();
                tra.setId(cita.getIdTratamiento());
                //Tratamiento tratamiento= tratamientoService.muestraUnoId(cita.getIdTratamiento());
                Tratamiento tratamiento = tratamientoService.mostrarUno(tra);
                listaTrat.add(tratamiento);
            }

            // Asignamos al request el atributo lista 
            request.getSession().setAttribute("citas", listaCita);
            request.getSession().setAttribute("clientes", listaCli);
            request.getSession().setAttribute("tratamientos", listaTrat);
            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarCitas.jsp");
            // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            List lista = clienteService.listarClientes();
            ArrayList<Cliente> clientes = new ArrayList<>(lista);
            request.getSession().setAttribute("listaClientes", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("/listarCliente.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listarTratamientos(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Ejecutamos el metodo y obtenemos la lista
            List lista = tratamientoService.listaTratamientos();
            ArrayList<Tratamiento> listatrat = new ArrayList<>(lista);
            // Asignamos al request el atributo lista 
            request.getSession().setAttribute("tratamientos", listatrat);
            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarTratamientos.jsp");
            // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getSession().getAttribute("listaClientes");

            String accion = request.getParameter("accion");
            if (accion.equals("cambiarDatos")) {
                String[] clientesMarcados = request.getParameterValues("clienteChecked");
                if (clientesMarcados != null) {
                    ArrayList<Cliente> clientesAModificar = new ArrayList<Cliente>();
                    for (int i = 0; i < clientesMarcados.length; i++) {
                        int idClienteMarcado = Integer.parseInt(clientesMarcados[i]);
                        for (int j = 0; j < listaClientes.size(); j++) {
                            if (listaClientes.get(j).getId() == idClienteMarcado) {
                                clientesAModificar.add(listaClientes.get(j));
                            }
                        }
                    }
                    request.setAttribute("clientesModificar", clientesAModificar);
                    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/modificarCliente.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listarClientes.jsp");
                    rd.forward(request, response);
                }
            }
            if (accion.equals("confirmarModif")) {
                String[] idModificar = request.getParameterValues("id");
                String[] nombres = request.getParameterValues("nombre");
                String[] apellidos = request.getParameterValues("apellidos");
                String[] sexo = request.getParameterValues("sexo");
                String[] dnis = request.getParameterValues("dni");
                String[] telefonos = request.getParameterValues("telefono");
                String[] emails = request.getParameterValues("email");

                for (int i = 0; i < idModificar.length; i++) {
                    int idCliente = Integer.parseInt(idModificar[i]);
                    Cliente cliente = new Cliente();
                    cliente.setId(idCliente);
                    cliente.setNombre(nombres[i]);
                    cliente.setApellidos(apellidos[i]);
                    cliente.setSexo(sexo[i]);
                    cliente.setDni(dnis[i]);
                    cliente.setTelefono(telefonos[i]);
                    cliente.setEmail(emails[i]);

                    try {
                        clienteService.modificar(cliente);
                    } catch (Exception e) {
                        //Informamos cualquier error
                        e.printStackTrace();
                    }

                }

                List lista = clienteService.listarClientes();
                ArrayList<Cliente> clientes = new ArrayList<>(lista);
                request.getSession().setAttribute("listaClientes", clientes);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listarCliente.jsp");
                rd.forward(request, response);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modificarTratamiento(HttpServletRequest request, HttpServletResponse response) {
        try {
            //Viene de listar o de modificar?
            String opcion = request.getParameter("opcion");

            if (opcion != null && opcion.equals("editar")) {

                //1. Recuperamos el id del tratamiento seleccionado
                String idTratamiento = request.getParameter("id");
                if (idTratamiento != null) {
                    //2. Creamos el objeto tratamiento a recuperar
                    int id = Integer.valueOf(idTratamiento);
                    Tratamiento tratamiento = new Tratamiento();
                    tratamiento.setId(id);
                    try {
                        tratamiento = this.tratamientoService.findTratamientoById(tratamiento);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //3. Compartimos el objeto tratamiento en alcance request
                    request.setAttribute("tratamiento", tratamiento);

                    //4. Redireccionamos a la pagina para editar el objeto Tratamiento
                    request.getRequestDispatcher("/modificarTratamiento.jsp").forward(request, response);
                }
            } else if (opcion != null && opcion.equals("modificar")) {

                //1. Recuperamos los parametros
                int idTratamiento = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                double precio = Double.parseDouble(request.getParameter("precio"));
                double duracion = Double.parseDouble(request.getParameter("duracion"));
                int sala = Integer.parseInt(request.getParameter("sala"));

                //2. Creamos el objeto Tratamiento
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setId(idTratamiento);
                tratamiento.setNombreTrat(nombre);
                tratamiento.setPrecioTrat(precio);
                tratamiento.setDuracionTrat(duracion);
                tratamiento.setSala(sala);

                try {
                    tratamientoService.updateTratamiento(tratamiento);
                } catch (Exception e) {
                    //Informamos cualquier error
                    e.printStackTrace();
                }

                // Volvemos a cargar la lista de tratamientos
                List lista = tratamientoService.listaTratamientos();
                ArrayList<Tratamiento> tratamientos = new ArrayList<>(lista);
                request.getSession().setAttribute("tratamientos", tratamientos);
                RequestDispatcher rd = request.getRequestDispatcher("/listarTratamientos.jsp");
                rd.forward(request, response);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ventaProductos(HttpServletRequest request, HttpServletResponse response) {

        String accion = request.getParameter("accion");

        String fechaVenta;
        int idCliente;
        String[] idProductos;

        switch (accion) {
            case "comienzo":
                try {
                    // Ejecutamos el metodo y obtenemos las lista de Productos y Clientes
                    List listaProd = productoService.listaProductos();
                    ArrayList<Producto> listaprod = new ArrayList<>(listaProd);

                    List listaCli = clienteService.listarClientes();
                    ArrayList<Cliente> clientes = new ArrayList<>(listaCli);

                    // Asignamos al request el atributo lista 
                    request.getSession().setAttribute("listaProductos", listaprod);
                    request.getSession().setAttribute("listaClientes", clientes);

                    // Pasamos al RequestDispatcher la pagina a cargar
                    RequestDispatcher rd = request.getRequestDispatcher("/ventaProductos.jsp");
                    // Cargamos la pagina
                    rd.forward(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case "confirmarVenta":
                fechaVenta = request.getParameter("dia");
                idCliente = Integer.parseInt(request.getParameter("clienteChecked"));
                idProductos = (request.getParameterValues("productoChecked"));//este array es de Strings

                try {
                    // Creamos el objeto Venta
                    Venta venta = new Venta();
                    venta.setFecha(fechaVenta);

                    // Recuperamos el objeto cliente
                    Cliente cliente = new Cliente();
                    cliente.setId(idCliente);
                    cliente = clienteService.mostrarUno(cliente);

                    //Creamos un ArrayList de productos
                    ArrayList<Producto> productosVendidos = new ArrayList<>();

                    for (int i = 0; i < idProductos.length; i++) {
                        int idProd = Integer.parseInt(idProductos[i]);
                        Producto prod = new Producto();
                        prod.setId(idProd);
                        //Producto producto = productoService.findProductoById(prod);
                        productosVendidos.add(prod);
                    }

                    ventaService.addVenta(venta, cliente, productosVendidos);

                    // Pasamos al RequestDispatcher la pagina a cargar
                    String ventaRealizada = "1";//funciona como un switch
                    request.setAttribute("ventaRealizada", ventaRealizada);
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    // Cargamos la pagina
                    rd.forward(request, response);

                } catch (Exception e) {
                    //Informamos cualquier error 
                    e.printStackTrace();
                }

                break;
        }

        /*
        try {
            int idCliente;
            String accion = request.getParameter("accion");//debe venir del envio desde el index.jsp
            String[] idProductos;
            ArrayList<Producto> productosVendidos = new ArrayList<>();

            switch (accion) {
                case "comienzo":
                    ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getSession().getAttribute("listaClientes");
                    if (listaClientes == null) {
                        List lista = clienteService.listarClientes();
                        listaClientes = (ArrayList<Cliente>) lista;
                    }
                    request.getSession().setAttribute("listaClientes", listaClientes);
                    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/seleccionClientesVentas.jsp");
                    rd.forward(request, response);
                    ;
                    break;
                case "selectCliente":
                    idCliente = Integer.parseInt(request.getParameter("clienteChecked"));
                    request.getSession().setAttribute("idCliente", idCliente);

                    ArrayList<Producto> listaProductos = productoService.listarProductos();

                    request.setAttribute("listaProductos", listaProductos);
                    rd = this.getServletContext().getRequestDispatcher("/seleccionProductosVentas.jsp");
                    rd.forward(request, response);
                    ;
                    break;
                case "selectProducto":
                    idCliente = (int) request.getSession().getAttribute("idCliente");
                    Cliente cl = new Cliente();
                    cl.setId(idCliente);
                    Cliente cliente = clienteService.mostrarUno(cl);

                    Double precioTotalVenta = 0.0;

                    idProductos = (request.getParameterValues("productoChecked"));//este array es de Strings
                    request.getSession().setAttribute("idProductos", idProductos);
                    if (idProductos != null) {
                        for (int i = 0; i < idProductos.length; i++) {
                            int idProd = Integer.parseInt(idProductos[i]);
                            Producto prod = new Producto(idProd, "", "", 0);
                            Producto producto = productoService.mostrarUno(prod);
                            productosVendidos.add(producto);
                            precioTotalVenta += producto.getPrecioProducto();
                        }
                    }

                    request.setAttribute("cliente", cliente);
                    request.setAttribute("prodsVendidos", productosVendidos);
                    request.setAttribute("precioTotal", precioTotalVenta);
                    rd = this.getServletContext().getRequestDispatcher("/finalizarVentaProductos.jsp");
                    rd.forward(request, response);

                    ;
                    break;
                case "confirmarVenta":
                    idCliente = (int) request.getSession().getAttribute("idCliente");
                    idProductos = (String[]) request.getSession().getAttribute("idProductos");
                    String fechaVenta = request.getParameter("fechaVenta");
                    for (int i = 0; i < idProductos.length; i++) {
                        int idProd = Integer.parseInt(idProductos[i]);
                        Venta venta = new Venta(0, idCliente, idProd, fechaVenta);
                        ventaService.agregarVenta(venta);
                    }
                    String ventaRealizada = "1";//funciona como un switch
                    request.setAttribute("ventaRealizada", ventaRealizada);
                    rd = this.getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                    ;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Ejecutamos el metodo y obtenemos la lista
            List lista = productoService.listaProductos();
            ArrayList<Producto> listaprod = new ArrayList<>(lista);
            // Asignamos al request el atributo lista 
            request.getSession().setAttribute("productos", listaprod);
            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarProductos.jsp");
            // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void listarVentas(HttpServletRequest request, HttpServletResponse response) {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "comienzo":
                try {
                    // Ejecutamos el metodo y obtenemos la lista
                    List lista = ventaService.listaVentas();
                    ArrayList<Venta> listaVenta = new ArrayList<>(lista);
                    // Asignamos al request el atributo lista 
                    request.getSession().setAttribute("ventas", listaVenta);
                    // Pasamos al RequestDispatcher la pagina a cargar
                    RequestDispatcher rd = request.getRequestDispatcher("/listarVentas.jsp");
                    // Cargamos la pagina
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "listarProd":
                try {
                    //1. Recuperamos los parametros de la persona 
                    String id = request.getParameter("id");
                    Venta v = new Venta();
                    v.setId(Integer.valueOf(id));
                    v = ventaService.findVentaById(v);

                    // Asignamos al request el atributo lista
                    ArrayList<Producto> listaArrayProductos = new ArrayList<>(v.getProductos());
                    request.getSession().setAttribute("productos", listaArrayProductos);

                    // Pasamos al RequestDispatcher la pagina a cargar
                    RequestDispatcher rd = request.getRequestDispatcher("/listarVentaCompleta.jsp");
                    // Cargamos la pagina
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }

    }
}
