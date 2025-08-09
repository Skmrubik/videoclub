package com.videoclub.dto;

import java.util.ArrayList;
import java.util.List;

import com.videoclub.entities.FilmCategory;

public class FilmPagination {
	private int totalPage;
	private int currentPage;
	private List<FilmCategory> listFilmPage;
	
	public FilmPagination(int totalPage, int currentPage, List<FilmCategory> listFilmPage) {
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.listFilmPage = listFilmPage;
	}

	public FilmPagination() {
		listFilmPage = new ArrayList<>();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<FilmCategory> getListFilmPage() {
		return listFilmPage;
	}

	public void setListFilmPage(List<FilmCategory> listFilmPage) {
		this.listFilmPage = listFilmPage;
	}

}
