package com.kalai.hibernate.crud;

import com.kalai.hibernate.entity.Song;

public interface CrudOperation {

	public boolean insertData(Song song);

	public Song getData(int id);

	public boolean updateData(Song song);

	public boolean deleteData(Song song);

}
