<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="ensignantheader.html"%>

<div class="col-md-12">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Liste Groupe</h3>
		</div>
		<form class="form-horizontal" action="DevoirSurveilleServlet" method="get">
			<div class="box-body">
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Groupe</label>
                  <div class="col-sm-6">
                  <select class="form-control" name="idgroupe">
                 		 <c:forEach items="${requestScope.list}" var="list">          
                  						
						<option value='<c:out value="${list.groupe.id}"></c:out>' ><c:out value="${list.groupe.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>	
                <div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Matiere</label>
                  <div class="col-sm-6">
                  <select class="form-control" name="idmatiere">
                 		 <c:forEach items="${requestScope.list}" var="list">          
                  						
						<option value='<c:out value="${list.matiere.id}"></c:out>' ><c:out value="${list.matiere.libelle}"></c:out></option>	
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
		</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

	<!-- /.box -->
	<!-- general form elements disabled -->

<div class="col-md-12">
	<!-- Horizontal Form -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Saisie Note De  ${requestScope.groupe.libelle }   Pour la Matiere   ${requestScope.matiere.libelle }</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
	
<form class="form-horizontal" action="DevoirSurveilleServlet" method="post">
			<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Nom et Prenom</th>
						<th>Note TP</th>
						<th>Note TD</th>
						<th>Note Presentielle</th>			
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.listetudiant}" var="listetudiant">
						<tr>
							<td><%=i++%></td>
							<td><c:out value="${listetudiant.nom} ${listetudiant.prenom}"></c:out></td>
							<td><input type="text" class="form-control" name="TP${listetudiant.id}" /></td>
							<td><input type="text" class="form-control"  name="TD${listetudiant.id}"></td>
							<td><input type="text" class="form-control"  name="TPS${listetudiant.id}" ></td>
							

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Enregistrer</button>
			</div>
			<!-- /.box-footer -->
			</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

<%@include file="footer.html"%>
