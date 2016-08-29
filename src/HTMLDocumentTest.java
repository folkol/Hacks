import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

public class HTMLDocumentTest {
    public static void main(String[] args) {
        HTMLDocument.Iterator iterator = new HTMLDocument.Iterator() {
            @Override
            public AttributeSet getAttributes() {
                return null;
            }

            @Override
            public int getStartOffset() {
                return 0;
            }

            @Override
            public int getEndOffset() {
                return 0;
            }

            @Override
            public void next() {

            }

            @Override
            public boolean isValid() {
                return false;
            }

            @Override
            public HTML.Tag getTag() {
                return null;
            }
        };
    }
}
