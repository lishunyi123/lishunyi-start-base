package com.lishunyi.jpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public interface BaseRepository<T, ID extends Serializable>
	extends JpaRepository<T, ID>,
	JpaSpecificationExecutor<T>,
	PagingAndSortingRepository<T, ID> {
}
