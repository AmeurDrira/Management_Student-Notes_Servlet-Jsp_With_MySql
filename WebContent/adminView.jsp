<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>


<div class="col-md-12">

	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Liste Admin</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Login</th>
						<th>Mot de passe</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.liste}" var="liste">
						<tr>

							<td><%=i++%></td>



							<td><c:out value="${liste.login}"></c:out></td>
							<td><c:out value="${liste.password}"></c:out></td>

							<td><a href=AdminServlet?action=update&id=<c:out value="${liste.id}"></c:out>>
									<button type="button" class="btn btn-default" >

										<span class="glyphicon glyphicon-edit"></span>
									</button>
							</a></td>
							<td><a href=AdminServlet?action=delete&id=<c:out value="${liste.id}"></c:out>>
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-remove"></span>

									</button>
							</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>

	<!-- /.box -->
	<!-- general form elements disabled -->

<div class="col-md-12">
	<!-- Horizontal Form -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Ajouter Et Modifier Admin</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal" action="AdminServlet" method="post">
			<div class="box-body">
				<div class="form-group">
				<input type="hidden" name="id" value="${requestScope.obj.id }">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="Login" name="login"
							value='<c:out value="${requestScope.obj.login }"></c:out>' required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							placeholder="Mot de passe" name="pwd"
							value='<c:out value="${requestScope.obj.password }"></c:out>' required>
					</div>
				</div>

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default ">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Submit</button>
			</div>
			<!-- /.box-footer -->
		</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

<%@include file="footer.html"%>
