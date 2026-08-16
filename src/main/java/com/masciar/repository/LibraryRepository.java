package com.masciar.repository;

import com.masciar.dao.LibraryDAO;
import com.masciar.model.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
public List<Library> library_list = new ArrayList<>();

    public LibraryRepository() {
        LibraryDAO libraryDao = new LibraryDAO();
        library_list = libraryDao.getAll();
    }

    public List<Library> getList() {
        return library_list;
    }
}
