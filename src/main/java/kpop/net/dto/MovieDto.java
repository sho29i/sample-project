package kpop.net.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class MovieDto {


//	comment_id
//	group_id
//	member_id
//	work_id
//	
	@Column(name = "ID")
	@Id
    public String movieId;
    
    public String title;

    public String description;

    /**
     * 動画URL
     */
    public String movieUrl;
    
    /**
     * サムネイル
     */
    public String thumbnail;
    
    /**
     * 再生時間
     */
    public String playtime;
    
    /**
     * 再生数
     */
    public BigDecimal view;
    
    /**
     * いいね数
     */
    public BigDecimal likes;
    
//    /**
//     * タグリスト
//     */
//    public List<TagDto> tagDtoList;
    

    



    


}
