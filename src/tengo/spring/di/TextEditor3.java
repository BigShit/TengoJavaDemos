package tengo.spring.di;

public class TextEditor3 {
	private SpellChecker spellChecker;

	public TextEditor3() {
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	// ����һ�����ú������������Ը�����ڲ���������ֵ
	public void setSpellChecker2(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
