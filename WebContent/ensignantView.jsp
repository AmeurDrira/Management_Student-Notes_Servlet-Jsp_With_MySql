<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>


<div class="col-md-12">

	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Liste Ensignant</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date de Naissance</th>
						<th>Cin</th>
						<th>Tel</th>
						<th>Login</th>
						<th>Password</th>
						<th>Modifier</th>
						<th>Supprimer</th>
						
						
						
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.liste}" var="liste">
						<tr>

							<td><%=i++%></td>
							<td><c:out value="${liste.nom}"></c:out></td>
							<td><c:out value="${liste.prenom}"></c:out></td>
							<td><c:out value="${liste.dateNaissance}"></c:out></td>
							<td><c:out value="${liste.cin}"></c:out></td>
							<td><c:out value="${liste.tel}"></c:out></td>
							<td><c:out value="${liste.login}"></c:out></td>
							<td><c:out value="${liste.password}"></c:out></td>

							<td><a href=EnsignantServlet?action=update&id=<c:out value="${liste.id}"></c:out>>
									<button type="button" class="btn btn-default" >

										<span class="glyphicon glyphicon-edit"></span>
									</button>
							</a></td>
							
							<td><a href=EnsignantServlet?action=delete&id=<c:out value="${liste.id}"></c:out>>
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
<div class="col-md-12">
	<!-- Horizontal Form -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Ajouter Ensignant</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal" action="EnsignantServlet" method="post">
			<div class="box-body">
			
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Nom</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="nom">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Prenom</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="prenom">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Date de Naissance</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="AAAA-MM-JJ" name="dateNaissance">
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Telephone</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="tel">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">carte d'identite</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="cin">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Login</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="login">
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Mot de passe</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="pwd">
					</div>
				</div>

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Ajouter</button>
			</div>
			<!-- /.box-footer -->
		</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>
<div class="col-md-12">
	<!-- Horizontal Form -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Modifier Ensignant</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
	
<form class="form-horizontal" action="EnsignantServlet" method="post">
			<div class="box-body">
			
			<input type="hidden" name="id" value="${requestScope.obj.id }">
			
								
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Nom</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="nom" value='<c:out value="${requestScope.obj.nom }"></c:out>'>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Prenom</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="prenom" value='<c:out value="${requestScope.obj.prenom }"></c:out>'>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Date de Naissance</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="AAAA-MM-JJ" name="dateNaissance"value='<c:out value="${requestScope.obj.dateNaissance }"></c:out>'>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Telephone</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="tel" value='<c:out value="${requestScope.obj.tel }"></c:out>'>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">carte d'identite</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="cin" value='<c:out value="${requestScope.obj.cin }"></c:out>'>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Login</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="login"value='<c:out value="${requestScope.obj.login }"></c:out>'>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Mot de passe</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="pwd" value='<c:out value="${requestScope.obj.password }"></c:out>'>
					</div>
				</div>

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Modifier</button>
			</div>
			<!-- /.box-footer -->
			</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

<%@include file="footer.html"%>
