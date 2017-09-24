package sample.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import kpop.net.dto.MovieDto;
//import kpop.net.dto.TagDto;
import kpop.net.service.TopContentsService;

/** 
 * TOPページ表示アクション
 * @author shotaro
 *
 */
public class KpopAction {

	// ====================================================
	//                                         DI
	//                                        =============
	
//	@Resource
//	@ActionForm
//	public IndexForm indexForm;
	
	@Resource
	protected TopContentsService topContentsService;
	
	@Resource
	protected HttpServletResponse response;

	// ====================================================
	//                                         プロパティ
	//                                        =============
	
    /** タグ情報 */
	//public List<TagDto> tagDtoList;
	
	/** 動画情報（更新順） */
	public List<MovieDto> movieDtoList;
	
	/** ランクイン動画情報 */
	//public List<MovieDto> rankInMovieDtoList;
	
	// ====================================================
	//                                         実行メソッド
	//                                        =============
	
	@Execute(validator = false)
	public String index(){
		
		//新着動画を取得
		List<MovieDto> newMovieDtoList = topContentsService.getNewMovieDtoList();
		
//		//人気動画を取得
//		List<MovieDto> rankMovieDtoList = topContentsService.getRankMovieDtoList();
//		
//		//人気メンバーを取得
//		List<MemberDto> rankMemberDtoList = topContentsService.getRankMemberDtoList();		
//
//		//人気グループを取得
//		List<GroupDto> rankGroupDtoList = topContentsService.getRankGroupDtoList();			
		
		return "top1.jsp";
		
	}
	
	
}
