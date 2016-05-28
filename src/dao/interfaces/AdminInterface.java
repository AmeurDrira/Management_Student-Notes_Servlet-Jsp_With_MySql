package dao.interfaces;

import java.util.List;

import model.Admin;

public interface AdminInterface {
	public void insertAdmin(Admin admin);

	public void updateAdmin(Admin admin);

	public void deleteAdmin(Admin admin);

	public Admin findByIdAdmin(int id);

	public List<Admin> getAllAdmin();

}
