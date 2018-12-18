package tengo.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor2 {

	private SpellChecker spellChecker;

	// ���幹�캯���Զ�װ�䣬������xml�ļ�����Ͳ���Ҫдproperty�����ӵ������ˣ���ܻ��Զ�����������bean����Ӧ��bean�����
	@Autowired
	public TextEditor2(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
