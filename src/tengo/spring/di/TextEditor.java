package tengo.spring.di;

/*
 * ʹ��di֮�������Ķ������ͨ�����캯������
 * */
public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}

/*
 * ��ͳ��������һ��������new����һ����Ķ��������͵����������������������һ���ࣺ
 * 
 * public class TextEditor {
 * 
 * private SpellChecker spellChecker;
 * 
 * public TextEditor() {
 * 
 * spellChecker = new SpellChecker();
 * 
 * }
 * 
 * }
 */
