package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.Album;

// interface로 만들기
// dao와 mapper은 쌍
@Repository
public interface AlbumDAO {
	public List<Album> selectAlbumList();
}
