package tengo.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	// �����Զ�װ�䣬������xml�ļ�����Ͳ���Ҫдproperty�����ӵ������ˣ���ܻ��Զ�����������bean����Ӧ��bean�����
	@Autowired
	private SpellChecker spellChecker;

	public TextEditor() {
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
