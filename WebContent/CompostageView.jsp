<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>

<div class="col-md-12">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Liste Groupe</h3>
		</div>
		<form class="form-horizontal" action="CompostageServlet" method="get">
			<div class="box-body">
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Groupe</label>
                  <div class="col-sm-6">
                  <select class="form-control" name="idgroupe">
                 		 <c:forEach items="${requestScope.listeGroupe}" var="listeGroupe">          
                  						
						<option value='<c:out value="${listeGroupe.id}"></c:out>' ><c:out value="${listeGroupe.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>	
                <div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Matiere</label>
                  <div class="col-sm-6">
                  <select class="form-control" name="idmatiere">
                 		 <c:forEach items="${requestScope.listeMatiere}" var="listeMatiere">          
                  						
						<option value='<c:out value="${listeMatiere.id}"></c:out>' ><c:out value="${listeMatiere.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>
				

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				
				<button type="submit" class="btn btn-info pull-right">Composter</button>
			</div>
			<!-- /.box-footer -->
		</form>
		</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>
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
						<th>Nom Prenom</th>
						<th>Compostage</th>
						
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.listeNote}" var="listeNote">
						<tr>

							<td><%=i++%></td>



							<td><c:out value="${listeNote.etudiant.nom} ${listeNote.etudiant.prenom}"></c:out></td>
							<td><c:out value="${listeNote.numcompostage}"></c:out></td>

							
					</c:forEach>

				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>



<%@include file="footer.html"%>
