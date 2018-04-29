
package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.concurrent.Callable;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.MutantStarter;

public class NegateVariableMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyNegs() {
		createTesteeWith(new NegateVariableMutator());
	}

	  private static class HasInteger implements Callable<Integer> {

		    @Override
		    public Integer call() throws Exception {
		    	int x = 5;
		    	int y = 6 + x;
		      return y;
		    }

		  }

		  @Test
		  public void shouldReplaceInteger() throws Exception {
		    final Mutant mutant = getFirstMutant(HasInteger.class);
		    assertMutantCallableReturns(new HasInteger(), mutant, -11);
		  }

		  
	public static class HasIntegerMemberVariable implements Callable<Integer> {

		private int member2;
		private int member3;
		private int member4;

		@Override
		public Integer call() throws Exception {
			this.member4 = 4;
			this.member2 = 2 + member4;
			this.member3 = -3;
			return this.member2;
		}
	}

	@Test
	public void shouldNegateIntegerMemeberVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasIntegerMemberVariable.class);
		assertMutantCallableReturns(new MutantStarter<Integer>(HasIntegerMemberVariable.class), mutant, -6);
	}

	public static class HasIntegerVariable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int member4 = -4;
			int member2 = -2;
			int member3 = -3;
			return member2;
		}
	}

	@Test
	public void shouldNegateIntegerVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasIntegerVariable.class);
		assertMutantCallableReturns(new MutantStarter<Integer>(HasIntegerVariable.class), mutant, 2);
	}

	private static class HasDoubleMemberVariable implements Callable<Double> {
		private double member2;

		@Override
		public Double call() throws Exception {
			this.member2 = 2.0;
			return this.member2;
		}

	}

	@Test
	public void shouldNegateDoubleMemberVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasDoubleMemberVariable.class);
		assertMutantCallableReturns(new HasDoubleMemberVariable(), mutant, -2.0);
	}

	private static class HasLongMemberVariable implements Callable<Long> {
		private long member2;

		@Override
		public Long call() throws Exception {
			this.member2 = 2l;
			return this.member2;
		}

	}

	@Test
	public void shouldNegateLongMemberVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasLongMemberVariable.class);
		assertMutantCallableReturns(new HasLongMemberVariable(), mutant, -2l);
	}

}
