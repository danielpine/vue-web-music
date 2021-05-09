package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.SongList;
import com.example.demo.pojo.SongTag;

@Repository
public interface RecommendMapper {

	@Select("SELECT songid,style as tag,count as score from song_history h," +
	        "(SELECT DISTINCT l.song_id,s.style from list_song l join song_list s on l.song_list_id=s.id ORDER BY l.song_id) s "
	        +
	        "WHERE h.songid=s.song_id and userid=#{userId}")
	List<SongTag> getUserHistory(@Param("userId") Integer userId);

	@Select("SELECT  h.song_id as songid,style as tag,(select 5 from dual) as score  from collect h," +
	        "(SELECT DISTINCT l.song_id,s.style from list_song l join song_list s on l.song_list_id=s.id ORDER BY l.song_id) s "
	        +
	        "WHERE h.song_id=s.song_id and user_id=#{userId}")
	List<SongTag> getUserCollect(@Param("userId") Integer userId);

	@Select("select * from song_list where style=#{style} limit #{limit}")
	List<SongList> getLimitSongListByStlye(@Param("style") String style, @Param("limit") Integer limit);

}