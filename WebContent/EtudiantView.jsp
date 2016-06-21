<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>
<div class="col-md-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Liste Etudiant</h3>
		</div>
		<form class="form-horizontal" action="EtudiantServlet" method="get">
			<div class="box-body">
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Groupe</label>
                  <div class="col-sm-10">
                  <select class="form-control" name="idgroupe">
                 		 <c:forEach items="${requestScope.listeGroupe}" var="listeGroupe">          
                  						
						<option value='<c:out value="${listeGroupe.id}"></c:out>' ><c:out value="${listeGroupe.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>	
				

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				
				<button type="submit" class="btn btn-info pull-right">Chercher</button>
			</div>
			<!-- /.box-footer -->
		</form>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse</th>
						<th>Tel</th>
						<th>Cin</th>
						<th>Numero Inscription</th>
						<th>Groupe</th>												
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
							<td><c:out value="${liste.nom}"></c:out></td>
							<td><c:out value="${liste.prenom}"></c:out></td>
							<td><c:out value="${liste.adresse}"></c:out></td>
							<td><c:out value="${liste.tel}"></c:out></td>
							<td><c:out value="${liste.cin}"></c:out></td>
							<td><c:out value="${liste.numeroInscri}"></c:out></td>
							<td><c:out value="${liste.groupe.libelle}"></c:out></td>
							
							<td><c:out value="${liste.login}"></c:out></td>
							<td><c:out value="${liste.password}"></c:out></td>

							<td><a href=EtudiantServlet?action=update&id=<c:out value="${liste.id}"></c:out>>
									<button type="button" class="btn btn-default" >

										<span class="glyphicon glyphicon-edit"></span>
									</button>
							</a></td>
							<td><a href=EtudiantServlet?action=delete&id=<c:out value="${liste.id}"></c:out>>
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
			<h3 class="box-title">Ajouter ET Modifier Etudiant</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		
		<form class="form-horizontal" action="EtudiantServlet" method="post">
			<input type="hidden" name="idetudiant" value="${requestScope.obj.id }">
			<div class="box-body">			
				<div class="form-group">				
					<label for="inputEmail3" class="col-sm-2 control-label">Nom</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="nom"
							value='<c:out value="${requestScope.obj.nom }"></c:out>' required>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Prenom</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="prenom"
							value='<c:out value="${requestScope.obj.prenom }"></c:out>' required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Adresse</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="adresse"
							value='<c:out value="${requestScope.obj.adresse }"></c:out>' required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Carte d'identite</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="cin"
							value='<c:out value="${requestScope.obj.cin }"></c:out>' required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Numero d'inscription</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="numeroInscri"
							value='<c:out value="${requestScope.obj.numeroInscri }"></c:out>' required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Telephone</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							 name="tel"
							value='<c:out value="${requestScope.obj.tel }"></c:out>' required>
					</div>
				</div>
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Groupe</label>
                  <div class="col-sm-10">
                  <select class="form-control" name="idgroupe">
                 		 <c:forEach items="${requestScope.listeGroupe}" var="listeGroupe">          
                  						
						<option value='<c:out value="${listeGroupe.id}"></c:out>' ><c:out value="${listeGroupe.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
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
