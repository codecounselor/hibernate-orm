package org.hibernate.test.annotations.filter.subclass.singletable;

import org.hibernate.test.annotations.filter.subclass.SubClassTest;
import org.hibernate.testing.FailureExpectedWithNewMetamodel;

@FailureExpectedWithNewMetamodel
public class SingleTableTest extends SubClassTest{



	@Override
	protected Class[] getAnnotatedClasses() {
		return new Class[]{Animal.class, Mammal.class, Human.class};
	}

	@Override
	protected void persistTestData() {
		createHuman(false, 90);
		createHuman(false, 100);
		createHuman(true, 110);
	}


	private void createHuman(boolean pregnant, int iq){
		Human human = new Human();
		human.setName("Homo Sapiens");
		human.setPregnant(pregnant);
		human.setIq(iq);
		session.persist(human);
	}


}
