
public class Trie {
    private static class Entry implements Comparable<Entry> {
        String element;
        boolean isWordEnd = false;
        MyList<Entry> children = new MyList<Entry>();
        Entry(final String theElement) {
            element = theElement;
        }
        @Override
        public int compareTo(Entry other) {
            return element.compareTo(other.element);
        }
        public void display() {
            System.out.printf("%s:%s%n", element, children);
        }
        public String toString() {
            return element;
        }
    }
    private final Entry root;
    Trie() {
        root = new Entry("");
    }
    public final void compress() {
        compress(root);
    }
    private final void compress(final Entry current) {
        final MyList<Entry> kids = current.children;
        if (kids.size() == 1) {
            final Entry kid = kids.removeFirst();
            current.element = current.element.concat(kid.element);
            current.children = kid.children;
            compress(current);
        } else {
            for (final Entry child : kids) {
                compress(child);
            }
        }
    }
    public final void insert(final String word) {
        insert(word, 0, root);
    }
    private void insert(final String word, final int index, final Entry current) {
        final MyList<Entry> kids = current.children;
        final String element = String.valueOf(word.charAt(index));
        final Entry next = kids.insert(new Entry(element));
        if (index < word.length() - 1) {
            insert(word, index + 1, next);
        } else {
            next.isWordEnd = true;
        }

    }
    public void display() {
        display(root);
    }
    public static void display(final Entry e) {
        e.display();
        System.out.println("{");
        for (Entry c : e.children) {
            display(c);
        }
        System.out.println("}");
    }
}
