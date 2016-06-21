<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>
<script type="text/javascript">

</script>

<div class="col-md-12">

	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Liste Matiere Ensignant Group</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Groupe</th>
						<th>Matiere</th>						
						<th>Ensignant</th>
						<th>Modifier</th>
						<th>Supprimer</th>
						
						
						
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.listeMatiereEnsignant}" var="listeMatiereEnsignant">
						<tr>

							<td><%=i++%></td>
							<td><c:out value="${listeMatiereEnsignant.groupe.libelle}"></c:out></td>
							<td><c:out value="${listeMatiereEnsignant.matiere.libelle}"></c:out></td>
							
							<td><c:out value="${listeMatiereEnsignant.ensignant.nom} ${listeMatiereEnsignant.ensignant.prenom}"></c:out></td>
							

							<td><a href=MatiereEnsignantGroupServlet?action=update&id=<c:out value="${listeMatiereEnsignant.id}"></c:out>>
									<button type="button" class="btn btn-default" >

										<span class="glyphicon glyphicon-edit"></span>
									</button>
							</a></td>
							
							<td><a href=MatiereEnsignantGroupServlet?action=delete&id=<c:out value="${listeMatiereEnsignant.id}"></c:out>>
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
			<h3 class="box-title">Ajouter Modifier Liste Matiere Ensignant Group</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
	
<form class="form-horizontal" action="MatiereEnsignantGroupServlet" method="post">
			<div class="box-body">
			
			<input type="hidden" name="idmatiereEnsignant" value="${requestScope.obj.id }">
			
								
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
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Matiere</label>
                  <div class="col-sm-10">
                  <select class="form-control" name="idmatiere">
                 		 <c:forEach items="${requestScope.listeMatiere}" var="listeMatiere">          
                  						
						<option value='<c:out value="${listeMatiere.id}"></c:out>' ><c:out value="${listeMatiere.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>
				
				
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Ensignant</label>
                  <div class="col-sm-10">
                  <select class="form-control" name="idensignant">
                 		 <c:forEach items="${requestScope.listeEnsignant}" var="listeEnsignant">          
                  						
						<option value='<c:out value="${listeEnsignant.id}"></c:out>' ><c:out value="${listeEnsignant.prenom} ${listeEnsignant.nom}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>				
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Submit</button>
			</div>
			<!-- /.box-footer -->
			</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

<%@include file="footer.html"%>
