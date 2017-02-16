/** 1.获得要遍历的根目录进行遍历，保存文件绝对路径在list中（_FilePaths.java）
 * 2.根据list中的文件进行MD5计算 并利用Map比较是否存在  -- name这个Map保存（MD5，PATH）
 *   --rename这个Map保存（PATH,MD5）重复的文件路径 （RepeatInfo.java）
 * 3.输出rename用于操作，这里进行了一些包装（info.java）（RepeatInfo.java）
 * 4. 在列表中选择并删除选中的文件，支持多选（ChooseFrame.java）
 */
public class Test {
	public static void main(String[] args) {
		UI ui=new UI();
	

	}
}
