package froggy.models;

import java.util.Iterator;
import java.util.List;

public class Lake<Integer> implements Iterable<Integer> {

    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int index;
        private int count;
        private boolean foundAllEven;
        private Integer number;

        private Frog() {
            this.count = 0;
            this.index = -2;
            this.foundAllEven = false;
        }

        private void getNumber() {
            if (!this.foundAllEven) {
                if (this.index + 2 < numbers.size()) {
                    this.number = numbers.get(index += 2);
                    this.count++;
                    return;
                }

                this.index = -1;
                this.foundAllEven = true;

            }

            this.number = numbers.get(index += 2);
            this.count++;
        }

        @Override
        public boolean hasNext() {
            return count < numbers.size();
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                getNumber();
                return this.number;
            }
            return null;
        }
    }
}
