<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper" style="position: fixed;">

    <div class="page-sidebar  navbar-collapse collapse ">

        <ul class="page-sidebar-menu page-sidebar-menu-hover-submenu1"
            data-keep-expanded="false" data-auto-scroll="true"
            id="sidebar-menu-seller"
            data-slide-speed="200">
            <li class="heading">
                <h3>GENERAL</h3>
            </li>

            <li class="${active==1 ? "active":""}"><a href="/admin/dashboard">
                <i class="icon-bar-chart"></i> <span class="title">Dashboard</span>
            </a></li>
            <li class="${active==2 ? "active":"" }"><a href="/admin/users"> <i
                    class="icon-users"></i> <span class="title">User</span>
            </a></li>
            <li class="${active==3 ? "active":"" }"><a href="/admin/useredit"> <i
                    class="icon-user"></i> <span class="title">User edit</span>
            </a></li>
            <li class="${active==4 ? "active":"" }"><a href="/admin/brands"> <i
                    class="icon-tag"></i> <span class="title">Brand</span>
            </a></li>
            <li class="${active==5 ? "active":"" }"><a href="/admin/categories"> <i
                    class="icon-grid"></i> <span class="title">Category</span>
            </a></li>
            <li class="${active==6 ? "active":"" }"><a href="/admin/payments"> <i
                    class="icon-wallet"></i> <span class="title">Payment</span>
            </a></li>
            <li class="${active==7 ? "active":"" }"><a href="/admin/products"> <i
                    class="icon-handbag"></i> <span class="title">Products</span>
            </a></li>
            <li class="${active==8 ? "active":"" }"><a href="/admin/orders"> <i
                    class="icon-basket"></i> <span class="title">Orders</span>
            </a></li>
            <li class="${active==9 ? "active":"" }"><a href="/admin/orderview"> <i
                    class="icon-tag"></i> <span class="title">Orders view</span>
            </a></li>

        </ul>

    </div>
</div>
