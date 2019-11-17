<%-- 
    Document   : barangview
    Created on : Oct 15, 2019, 2:29:05 PM
    Author     : G551VW
--%>

<%@page import="models.Materi"%>
<%@page import="models.Trainer"%>
<%@page import="models.Room"%>
<%@page import="models.Shcedule"%>
<%@page import="models.Employee"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

        <!--Sweet Alert-->
        <script src="js/sweetalert2@8.js" type="text/javascript"></script>
        <script src="sweetalert2.all.min.js"></script>

        <!-- Optional: include a polyfill for ES6 Promises for IE11 and Android browser -->
        <script src="js/promise-polyfill.js" type="text/javascript"></script>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

    </head>
    <%
        List<Shcedule> shcedules = (List<Shcedule>) session.getAttribute("shcedules");
        List<Room> rooms = (List<Room>) session.getAttribute("rooms");
        List<Trainer> trainers = (List<Trainer>) session.getAttribute("trainers");
        List<Materi> materis = (List<Materi>) session.getAttribute("materis");

        if (shcedules != null) {
    %>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                    <div class="sidebar-brand-icon rotate-n-15">

                    </div>
                    <div class="sidebar-brand-text mx-3">Dashboard Admin</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Tables -->
                <li class="nav-item active">
                    <a class="nav-link" href="/TrainerFeedbacktest/dashboardAdmin.jsp">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Dashbord</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/TrainerFeedbacktest/schedule.jsp">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Schedule</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/TrainerFeedbacktest/form.jsp">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Manage Form</span></a>   
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Divider -->
                <hr class="sidebar-divider">                

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <!--                                                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                                                            <div class="input-group">
                                                                                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                                                <div class="input-group-append">
                                                                                    <button class="btn btn-primary" type="button">
                                                                                        <i class="fas fa-search fa-sm"></i>
                                                                                    </button>
                                                                                </div>
                                                                            </div>
                                                                        </form>-->

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - Alerts -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">3+</span>
                                </a>
                                <!-- Dropdown - Alerts -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                                    <h6 class="dropdown-header">
                                        Alerts Center
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-primary">
                                                <i class="fas fa-file-alt text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">December 12, 2019</div>
                                            <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-success">
                                                <i class="fas fa-donate text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">December 7, 2019</div>
                                            $290.29 has been deposited into your account!
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-warning">
                                                <i class="fas fa-exclamation-triangle text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">December 2, 2019</div>
                                            Spending Alert: We've noticed unusually high spending for your account.
                                        </div>
                                    </a>
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                                </div>
                            </li>

                            <!-- Nav Item - Messages -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-envelope fa-fw"></i>
                                    <!-- Counter - Messages -->
                                    <span class="badge badge-danger badge-counter">7</span>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                                    <h6 class="dropdown-header">
                                        Message Center
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                                            <div class="status-indicator bg-success"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div>
                                            <div class="small text-gray-500">Emily Fowler Â· 58m</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                                            <div class="status-indicator"></div>
                                        </div>
                                        <div>
                                            <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div>
                                            <div class="small text-gray-500">Jae Chun Â· 1d</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                                            <div class="status-indicator bg-warning"></div>
                                        </div>
                                        <div>
                                            <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div>
                                            <div class="small text-gray-500">Morgan Alvarez Â· 2d</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                                            <div class="status-indicator bg-success"></div>
                                        </div>
                                        <div>
                                            <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                                            <div class="small text-gray-500">Chicken the Dog Â· 2w</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                                </div>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>
                            <%
                                if (session.getAttribute("employee") != null && session.getAttribute("employee") != "") {

                                    Employee emp = (Employee) session.getAttribute("employee");

                            %>
                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=emp.getName()%></span>
                                    <img width="60" height="60" class="img-profile rounded-circle" src="data:image/jpeg;base64,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">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <!--                                    <a class="dropdown-item" href="#">
                                                                            <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                                                            Profile
                                                                        </a>
                                                                        <a class="dropdown-item" href="#">
                                                                            <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                                                            Settings
                                                                        </a>
                                                                        <a class="dropdown-item" href="#">
                                                                            <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                                                            Activity Log
                                                                        </a>
                                                                        <div class="dropdown-divider"></div>-->
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout 
                                    </a>
                                </div>
                            </li>
                            <%}%>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800"></h1>
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">
                                    <div style="float:left">                                        
                                        <label data-toggle="tooltip" title="Add Data"><button type="button" data-toggle="modal" data-target="#add" class="btn btn-secondary" style="font-size:17px;color:#FFFFFF;float:left;"><i class='far fa-plus-square'></i></button></label>
                                    </div>
                                    <!--                                    <div style="float:right;">
                                                                            <label data-toggle="tooltip" title="Cetak Data"><a href="reportMasuk.jsp" data-toggle="tooltip" title="Cetak Laporan" target="_blank" class="btn btn-info" style="font-size:17px;color:#FFFFFF;float:left;"><i class='fas fa-print'></i></a></label>
                                                                        </div>-->
                                </h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">                                    
                                    <table border="1" border="1" id="tabel-data" class="table table-striped table-bordered" width="100%" cellspacing="0">
                                        <thead>                                
                                            <tr>
                                                <th>No</th>
                                                <th>ID</th>
                                                <th style="display:none;">id trainer</th>
                                                <th>Trainer</th>                                                
                                                <th style="display:none;">id Title</th>                                                
                                                <th>Title</th>                                                
                                                <th style="display:none;">id Room</th>
                                                <th>Room</th>
                                                <th>Event Date</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                int record = 1;
                                                for (Shcedule shcedule : shcedules) {
                                            %>
                                            <tr>
                                                <td><%=record++%></td>
                                                <td><%=shcedule.getId()%></td>
                                                <td style="display:none;"><%=shcedule.getTrainer().getId()%></td>
                                                <td><%=shcedule.getTrainer().getName()%></td>
                                                <td style="display:none;"><%=shcedule.getTitle().getId()%></td>
                                                <td><%=shcedule.getTitle().getTitle()%></td>
                                                <td style="display:none;"><%=shcedule.getRoom().getId()%></td>                                                
                                                <td><%=shcedule.getRoom().getName()%></td>                                                
                                                <td><%=shcedule.getEventDate()%></td>
                                                <td>
                                                    <!--                                        <button type="button" class="coba">Test</button>-->
                                                    <label data-toggle="tooltip" title="Edit Data"><button type="button" data-toggle="modal" data-target="#edit" class="btn btn-warning" style="color:#FFFFFF;"><i class='fas fa-pencil-alt'></i></button>&nbsp;</label>
                                                    <!--                                                    <label data-toggle="tooltip" title="Delete Data"><button type="button" data-toggle="modal" data-target="#del" class="btn btn-danger"><i class='far fa-trash-alt'></i></button></label>-->
                                                    <!--<input type="text" name="txtCoba" id="txtCoba" value="" />-->
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>                                        
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <div class="container">     
                    <!--EDIT-->

                    <!-- The Modal -->
                    <form action="scheduleservlet" method="POST">
                        <div class="modal fade" id="edit" tabindex="-1" aria-labelledby="edit">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Edit Data</h4>
                                        <label data-toggle="tooltip" title="Tutup"><button type="button" class="close" data-dismiss="modal">&times;</button></label>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">

                                        <table border="0" width="98%">
                                            <tbody>
                                                <tr>
                                                    <td></td>

                                                    <td><input type="hidden" class="form-control" name="txtId" id="txtId" value="" autofocus/></td>                        
                                                </tr>
                                                <tr>
                                                    <td>Trainer Name<span style="color:red">*</span></td>
                                                    <td>
                                                        <select name="trainer" id="trainer" class="form-control">                                                           
                                                            <option value="null">-----------------</option>
                                                            <%
                                                                for (Trainer trainer : trainers) {
                                                            %>
                                                            <option value="<%=trainer.getEmployee().getId()%>"><%=trainer.getEmployee().getName()%></option>
                                                            <%}%>
                                                        </select>
                                                        <!--<input type="text" class="form-control" name="txtName" id="txtNames" value="" />-->
                                                    </td>                    
                                                </tr>
                                                <tr>
                                                    <td>Room Name<span style="color:red">*</span></td>
                                                    <td>
                                                        <select name="room" id="room" class="form-control">                                                           
                                                            <option value="null">-----------------</option>
                                                            <%
                                                                for (Room room : rooms) {
                                                            %>
                                                            <option value="<%=room.getId()%>"><%=room.getName()%></option>
                                                            <%}%>
                                                        </select>
                                                        <!--<input type="text" class="form-control" name="txtName" id="txtNames" value="" />-->
                                                    </td>                    
                                                </tr>
                                                <tr>
                                                    <td>Title<span style="color:red">*</span></td>
                                                    <td>
                                                        <select name="materi" id="materi" class="form-control">                                                           
                                                            <option value="null">-----------------</option>
                                                            <%
                                                                for (Materi materi : materis) {
                                                            %>
                                                            <option value="<%=materi.getId()%>"><%=materi.getTitle()%></option>
                                                            <%}%>
                                                        </select>
                                                        <!--<input type="text" class="form-control" name="txtName" id="txtNames" value="" />-->
                                                    </td>                    
                                                </tr>
                                                <tr>
                                                    <td>Tanggal<span style="color:red">*</span></td>
                                                    <td>
                                                        <input id="Tanggal" name="eventDate"/>
                                                        <script>
                                                            $('#Tanggal').datepicker({
                                                                uiLibrary: 'bootstrap4'
                                                            });
                                                        </script>
                                                    </td>                    
                                                </tr>    
                                            </tbody>
                                        </table>

                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <label data-toggle="tooltip" title="Save Data"><input type="submit" value="Save" id="btnAdd" name="button" class="btn btn-primary"/>&nbsp;</label>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>

                    <!--ADD-->   

                    <!-- The Modal -->
                    <form action="scheduleservlet" method="POST">
                        <div class="modal fade" id="add" tabindex="-1" aria-labelledby="add">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Add Data</h4>
                                        <label data-toggle="tooltip" title="Close"><button type="button" class="close" data-dismiss="modal">&times;</button></label>
                                    </div>

                                    <!-- Modal body -->

                                    <div class="modal-body">

                                        <table border="0" width="98%">
                                            <tbody>                                                
                                            <tr>
                                                <td>Trainer Name<span style="color:red">*</span></td>
                                                <td>
                                                    <select name="trainer" id="trainers" class="form-control">                                                           
                                                        <option value="null">-----------------</option>
                                                        <%
                                                            for (Trainer trainer : trainers) {
                                                        %>
                                                        <option value="<%=trainer.getEmployee().getId()%>"><%=trainer.getEmployee().getName()%></option>
                                                        <%}%>
                                                    </select>
                                                    <!--<input type="text" class="form-control" name="txtName" id="txtNames" value="" />-->
                                                </td>                    
                                            </tr>
                                            <tr>
                                                <td>Room Name<span style="color:red">*</span></td>
                                                <td>
                                                    <select name="room" id="rooms" class="form-control">                                                           
                                                        <option value="null">-----------------</option>
                                                        <%
                                                            for (Room room : rooms) {
                                                        %>
                                                        <option value="<%=room.getId()%>"><%=room.getName()%></option>
                                                        <%}%>
                                                    </select>
                                                    <!--<input type="text" class="form-control" name="txtName" id="txtNames" value="" />-->
                                                </td>                    
                                            </tr>
                                            <tr>
                                                <td>Title<span style="color:red">*</span></td>
                                                <td>
                                                    <select name="materi" id="materis" class="form-control">                                                           
                                                        <option value="null">-----------------</option>
                                                        <%
                                                            for (Materi materi : materis) {
                                                        %>
                                                        <option value="<%=materi.getId()%>"><%=materi.getTitle()%></option>
                                                        <%}%>
                                                    </select>
                                                    <!--<input type="text" class="form-control" name="txtName" id="txtNames" value="" />-->
                                                </td>                    
                                            </tr>
                                            <tr>
                                                <td>Tanggal<span style="color:red">*</span></td>
                                                <td  class="input-append date form_datetime">
                                                    <input name="eventDate" id="input" width="312" />
                                                    <script>
                                                        $('#input').datetimepicker({footer: true, modal: true});
                                                    </script>
                                                </td>                    
                                            </tr>   
                                            </tbody>
                                        </table>

                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <label data-toggle="tooltip" title="Save Data"><input type="submit" value="Save" id="btnAdd" name="button" class="btn btn-primary"/>&nbsp;</label>
                                    </div>

                                </div>                        
                            </div>
                        </div>
                    </form>

                    <!--Delete-->


                </div>


                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2019</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">.·´¯`(>▂<)´¯`·.</span>
                        </button>
                    </div>
                    <div class="modal-body">Choose "Logout" to end your session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="/TrainerFeedback/logoutServlet">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>

    </body>
    <% } else {
            response.sendRedirect("scheduleservlet");
        }
        session.removeAttribute("shcedules");
    %>
    <script>
                                                        $(document).ready(function () {

                                                            // code to read selected table row cell data (values).
                                                            $("#tabel-data").on('click', '.btn', function () {
                                                                // get the current row
                                                                var currentRow = $(this).closest("tr");

                                                                var No = currentRow.find("td:eq(0)").text(); // get current row 1st TD value
                                                                var ID = currentRow.find("td:eq(1)").text(); // get current row 2nd TD
                                                                var Trainer = currentRow.find("td:eq(2)").text(); // get current row 3rd TD
                                                                var Title = currentRow.find("td:eq(4)").text(); // get current row 6rd TD
                                                                var Room = currentRow.find("td:eq(6)").text(); // get current row 7rd TD
                                                                var EventDate = currentRow.find("td:eq(8)").text(); // get current row 7rd TD
//                                                                    var Stok = currentRow.find("td:eq(7)").text(); // get current row 8rd TD

                                                                //            var data = col1 + "\n" + col2 + "\n" + col3;

                                                                $("#txtId").val(ID);
                                                                $("#trainer").val(Trainer);
                                                                $("#materi").val(Title);
                                                                $("#room").val(Room);
                                                                $("#Tanggal").val(EventDate);




                                                                //            alert(data);
                                                            });
                                                        });
    </script>
    <script>
        $('#edit').on('shown.bs.modal', function () {
            $(this).find('#txtName').focus();
        });
    </script>
    <script>
        $('#add').on('shown.bs.modal', function () {
            $(this).find('#txtNames').focus();
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#tabel-data').DataTable();
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#btnSave').click(function (e) {
                var Id = $('#txtId').val();
                var Name = $('#txtName').val();
                var Tanggal = $('#txtTanggal').val();
                var Jumlah = $('#txtJumlah').val();
                var res;

                if (Id == "" || Name == "" || Tanggal == "" || Jumlah == "") {
                    $('#edit').modal('show');
                    Swal.fire({
                        title: 'Failed',
                        type: 'error',
                        text: 'Data Tidak Boleh Kosong',
                        showConfirmButton: false,
                        timer: 2000
                    })
                    return false
                } else {
                    Swal.fire({
                        title: 'Saved',
                        text: 'Success',
                        type: 'success',
                        showConfirmButton: false,
                        timer: 3000
                    })
                    return res;
                }
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#btnDel').click(function (e) {
                var Id = $('#txtId').val();
                var res;
                $('#del').modal('hide');
                if (Id == "") {
                    Swal.fire({
                        title: 'Failed',
                        type: 'error',
                        showConfirmButton: false,
                        timer: 2000
                    })
                    return false;
                } else {
                    Swal.fire({
                        title: 'Deleted',
                        text: 'Success',
                        type: 'success',
                        confirmButtonText: "Yes",
                        showConfirmButton: false,
                        timer: 3000
                    })
                }
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#btnAdd').click(function (e) {
                var Id = $('#txtIds').val();
                var Name = $('#txtNames').val();
                var Tanggal = $('#txtTanggals').val();
                var Jumlah = $('#txtJumlahs').val();
                var res;

                if (Id == "" || Name == "" || Tanggal == "" || Jumlah == "") {
                    $('#add').modal('show');
                    Swal.fire({
                        title: 'Gagal',
                        type: 'error',
                        text: 'Data tidak boleh kosong',
                        showConfirmButton: false,
                        timer: 2000
                    })
                    return false
                } else {
                    Swal.fire({
                        title: 'Berhasil',
                        type: 'success',
                        confirmButtonText: "Yes",
                        showConfirmButton: false,
                        timer: 3000
                    })
                }
            });
        });
    </script>
    <script>
        // Restricts input for the given textbox to the given inputFilter.
        function setInputFilter(textbox, inputFilter) {
            ["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function (event) {
                textbox.addEventListener(event, function () {
                    if (inputFilter(this.value)) {
                        this.oldValue = this.value;
                        this.oldSelectionStart = this.selectionStart;
                        this.oldSelectionEnd = this.selectionEnd;
                    } else if (this.hasOwnProperty("oldValue")) {
                        this.value = this.oldValue;
                        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
                    }
                });
            });
        }
        // Install input filters.    
        setInputFilter(document.getElementById("txtJumlah"), function (value) {
            return /^\d*$/.test(value) && (value === "" || parseInt(value) <= 500);
        });
        setInputFilter(document.getElementById("txtJumlahs"), function (value) {
            return /^\d*$/.test(value) && (value === "" || parseInt(value) <= 500);
        });
    </script>
</html>
