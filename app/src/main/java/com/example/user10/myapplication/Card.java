package com.example.user10.myapplication;



    class Card {
    private  int count, fill, shape, color;

        public int getCount() {
            return count;
        }

        public int getFill() {
            return fill;
        }

        public int getShape() {
            return shape;
        }

        public int getColor() {
            return color;
        }

        public Card(int count, int fill, int shape, int color) {
            this.count = count; this.fill = fill; this.shape = shape; this.color = color;
        }

        public boolean equals(Card card) {
            if (this.count != card.count) return false;
            if (this.fill != card.fill) return false;
            if (this.shape != card.shape) return false;
            return this.color == card.color;

        }

        @Override
        public int hashCode() {
            int result = count;
            result = 31 * result + fill;
            result = 31 * result + shape;
            result = 31 * result + color;
            return result;
        }
}
