<%-- 
    Document   : Productos
    Created on : 30/10/2024, 8:51:46 p. m.
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Marca" %>
<%@page import="modelo.Productos" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <style>
        .container {
            max-width: 800px; /* Limitar el ancho del contenedor */
        }
        h1 {
            text-align: center; /* Centrar el título */
            margin-bottom: 20px; /* Espaciado inferior */
        }
        .form-group {
            margin-bottom: 20px; /* Espaciado inferior entre los formularios */
        }
    </style>
    </head>
    
    <body>
        <div class="container mt-5">
        <h1>Formulario Productos</h1>
        <div class="card mb-4">
            <div class="card-header">
        <a href="vistaMarca.jsp" class="btn btn-secondary">Marcas</a>
         <div class="card-body"> 
            <form action="SR_Productos" method="post" onsubmit="return validarFormulario();">
                <div class="mb-3">
                <label for="lbl_ID"><b>ID:</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly required maxlength="100"  >
                </div>
                <div class="mb-3">
                <label for="lbl_Producto"><b>Producto:</b></label>
                <input type="text" name="txt_producto" class="txt_producto" id="txt_producto" class="form-control" placeholder="Ejemplo: Zapatos, camisas" required maxlength="100">
                </div>
                <div class="mb-3">
                <label for="lbl_marca"><b>Marca:</b></label>
                <select name="drop_marca" id="drop_marca" class="form-control">
                    <%
                      Marca marcas = new Marca();
                      HashMap<String,String> drop = marcas.drop_sangre();
                      for (String i: drop.keySet()){
                        out.println("<option value = '" + i + "' > " + drop.get(i) + " </option>");
                        }
                    %>
                </select>
                </div>
                <div class="mb-3">
                <label for="lbl_Descripcion"><b>Descripción:</b></label>
                <input type="text" name="txt_descripcion" class="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Ejemplo: Talla x, color x" required maxlength="100">
                </div>
                <div class="mb-3">
                <label for="lbl_Imagen"><b>Imagen</b></label>
                <input type="text" name="txt_imagen" class="txt_imagen" id="txt_imagen" class="form-control" required maxlength="100">
                <img src="img/CamisaMorada.jpg">
                </div>
                <div class="mb-3">
                <label for="lbl_Costo"><b>Precio Compra (Q.):</b></label>
                <input type="text" name="txt_costo" class="txt_costo" id="txt_costo" class="form-control" placeholder="Ejemplo: 7.15" required maxlength="100">
                </div>
                <div class="mb-3">
                <label for="lbl_Venta"><b>Precio Venta (Q.):</b></label>
                <input type="text" name="txt_venta" class="txt_venta" id="txt_venta" class="form-control" placeholder="Ejemplo: 8.15" required maxlength="100">
                </div>
                <div class="mb-3">
                <label for="lbl_Existencia"><b>Existencia:</b></label>
                <input type="text" name="txt_existencia" class="txt_existencia" id="txt_existencia" class="form-control" value="0" readonly required maxlength="100">
                </div>
                <div class="mb-3">
                <label for="lbl_FI"><b>Fecha ingreso:</b></label>
                <input type="date" name="txt_fi" class="txt_fi" id="txt_fi" class="form-control" required maxlength="100">
                </div>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-warning">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger">Eliminar</button>
            </form>
         </div>
            </div>
                <table class="table table-striped mt-4">
    <thead>
      <tr>
       <td>Id</td>
        <td>productos</td>
        <td>Marcas</td>
        <td>Descripcion</td>
        <td>Imagen</td>
        <td>Precios Costo</td>
        <td>Precios Ventas</td>
        <td>Existencia</td>
         <td>Fecha Ingreso</td>
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <%
        Productos producto = new Productos();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = producto.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr>");
            out.println("<td>" + tabla.getValueAt(t, 0) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 8) + "</td>");
            out.println("</tr>");
        }
        %>
      </tbody>
  </table>
      </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script type="text/javascript">
    $(document).ready(function() {
        $('#tbl_productos').on('click', 'tr', function() {
            var target, id_Prod, productos, marcas, descripcion, imagen, costo, venta, existencia, fecha_ingreso;

            // Obtener la fila seleccionada
            target = $(this);

            // Extraer valores de cada columna en la fila
            id_Prod = target.find("td").eq(0).html(); 
            productos = target.find("td").eq(1).html(); 
            marcas = target.find("td").eq(2).html(); 
            descripcion = target.find("td").eq(3).html(); 
            imagen = target.find("td").eq(4).html(); 
            costo = target.find("td").eq(5).html(); 
            venta = target.find("td").eq(6).html(); 
            existencia = target.find("td").eq(7).html();
            fecha_ingreso = target.find("td").eq(8).html();
            

            // Asignar valores a los campos de formulario
            $("#txt_id").val(id_Prod);
            $("#txt_producto").val(productos);
            $("#txt_marca").val(marcas);
            $("#txt_descripcion").val(descripcion);
            $("#txt_imagen").val(imagen);
            $("#txt_costo").val(costo);
            $("#txt_venta").val(venta);
            $("#txt_existencia").val(existencia);
            $("#txt_fi").val(fecha_ingreso);
        });
    });
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
