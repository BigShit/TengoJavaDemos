package tengo.spring.di;

public class TextEditor2 {
	private SpellChecker spellChecker;

	public TextEditor2() {
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	// ����һ�����ú������������Ը�����ڲ���������ֵ
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
