import java.util.LinkedList;
import java.util.Queue;

public class Code_18_DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }

    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getPetType() {
            return this.pet.getType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnter> dogQueue;
        private Queue<PetEnter> catQueue;
        private long count;

        public DogCatQueue() {
            this.dogQueue = new LinkedList<PetEnter>();
            this.catQueue = new LinkedList<PetEnter>();
            this.count = 0;
        }

        public void add(Pet pet) {
            if (pet.getType().equals("Dog")) {
                this.dogQueue.add(new PetEnter(pet, this.count++));
            } else if (pet.getType().equals("Cat")) {
                this.catQueue.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("No dog or cat!!!");
            }
        }

        public Pet pollAll() {
            if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
                if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                    return this.dogQueue.poll().getPet();
                } else {
                    return this.catQueue.poll().getPet();
                }
            } else if (!this.dogQueue.isEmpty()) {
                return this.dogQueue.poll().getPet();
            } else if (!this.catQueue.isEmpty()) {
                return this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("The queue is empty!!!");
            }
        }

        public Dog pollDog() {
            if (!this.dogQueue.isEmpty()) {
                return (Dog) this.dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("The queue is empty!!!");
            }
        }

        public Cat pollCat() {
            if (!this.dogQueue.isEmpty()) {
                return (Cat) this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("The queue is empty!!!");
            }
        }

        public boolean isEmpty() {
            return (this.dogQueue.isEmpty() && this.catQueue.isEmpty());
        }

        public boolean isDogEmpty() {
            return this.dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return this.catQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQueue dogCatQueu = new DogCatQueue();
        Pet dog1 = new Dog();
        Pet dog2 = new Dog();
        Pet dog3 = new Dog();
        Pet cat1 = new Cat();
        Pet cat2 = new Cat();
        Pet cat3 = new Cat();

        dogCatQueu.add(dog1);
        dogCatQueu.add(dog2);
        dogCatQueu.add(cat1);
        dogCatQueu.add(cat2);
        dogCatQueu.add(cat3);
        System.out.println(dogCatQueu.pollAll().getType());
        System.out.println(dogCatQueu.pollCat().getType());
        dogCatQueu.add(dog3);
        System.out.println(dogCatQueu.pollDog().getType());
        System.out.println(dogCatQueu.isDogEmpty());
        System.out.println(dogCatQueu.pollDog().getType());
        System.out.println(dogCatQueu.isDogEmpty());
    }


}
