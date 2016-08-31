package orm;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper<T extends Serializable> {

	@Select("select name from person where surname = #{param1} and age = #{param2}")
	List<String> getName(@Param("#{param1}") String param1, @Param("#{param2}") int param2);

	@Select("select age from person where surname = #{param1}")
	List<Integer> getAge(@Param("#param1") String param1);
	
	@Select("select ${param} from ${param1}")
	 List<T> getByParam(@Param("param") String param, @Param("param1") String param1);
}
