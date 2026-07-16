package repository;

import dao.LibrariesDAO;
import model.Libraries;

import java.util.ArrayList;
import java.util.List;

public class LibrariesRepository {
public List<Libraries> library_list = new ArrayList<>();

    public LibrariesRepository() {
        LibrariesDAO libraryDao = new LibrariesDAO();
        library_list = libraryDao.getAll();
    }

    public List<Libraries> getList() {
        return library_list;
    }
}
