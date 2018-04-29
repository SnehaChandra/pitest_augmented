
package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.concurrent.Callable;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.MutantStarter;

public class CRCRMutateConstantWith1Test extends MutatorTestBase {

	@Before
	public void setupEngineToMutateConstWithOne() {
		createTesteeWith(new CRCRMutateConstantWith1());
	}

	  private static class HasInteger implements Callable<Integer> {

		    @Override
		    public Integer call() throws Exception {
		    	int x = 55;
		    	int y = 66 + x;
//		    	System.out.println(x);
//		    	System.out.println(y);
		      return y;
		    }

		  }

		  @Test
		  public void shouldReplaceInteger() throws Exception {
		    final Mutant mutant = getFirstMutant(HasInteger.class);
		    assertMutantCallableReturns(new HasInteger(), mutant, 1);
		  }

			public static class HasLADD implements Callable<Long> {

				private long member2;
				private long member1;
				private long result;

				@Override
				public Long call() throws Exception {
					this.member1 = 10;
					this.member2 = 2l;
					result = member1 + member2;
					System.out.println(result);
					return result;
				}
			}

			@Test
			public void shouldCnangeLongAdd() throws Exception {
				final Mutant mutant = getFirstMutant(HasLADD.class);
				assertMutantCallableReturns(new MutantStarter<Long>(HasLADD.class), mutant, 1l);
			}
	  
			public static class HasLMUL implements Callable<Long> {
				private long member2;
				private long member1;
				private long result;
				@Override
				public Long call() throws Exception {
					this.member1 = 12;
					this.member2 = 2;
					result = member1 * member2;
					System.out.println(result);
					return result;
				}
			}

			@Test
			public void shouldCnangeLongMUL() throws Exception {
				final Mutant mutant = getFirstMutant(HasLMUL.class);
				assertMutantCallableReturns(new MutantStarter<Long>(HasLMUL.class), mutant, 1l);
			}

	public static class HasIntegerMemberVariable implements Callable<Integer> {

		private int member2;
		private int member3;
		private int member4;

		@Override
		public Integer call() throws Exception {
			this.member4 = 4;
			this.member2 = 26 + member4;
			this.member3 = -3;
			return this.member2;
		}
	}

	@Test
	public void shouldNegateIntegerMemeberVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasIntegerMemberVariable.class);
		assertMutantCallableReturns(new MutantStarter<Integer>(HasIntegerMemberVariable.class), mutant, 1);
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
		assertMutantCallableReturns(new MutantStarter<Integer>(HasIntegerVariable.class), mutant, 1);
	}

	private static class HasDoubleMemberVariable implements Callable<Double> {
		private double member2;

		@Override
		public Double call() throws Exception {
			this.member2 = 2.0;
			System.out.println(this.member2);
			return this.member2;
		}

	}

	@Test
	public void shouldNegateDoubleMemberVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasDoubleMemberVariable.class);
		assertMutantCallableReturns(new HasDoubleMemberVariable(), mutant, 1.0);
	}

	private static class HasLongMemberVariable implements Callable<Long> {
		private long member2;

		@Override
		public Long call() throws Exception {
			this.member2 = 2l;
			System.out.println(this.member2);
			return this.member2;
		}

	}

	@Test
	public void shouldNegateLongMemberVariable() throws Exception {
		final Mutant mutant = getFirstMutant(HasLongMemberVariable.class);
		assertMutantCallableReturns(new HasLongMemberVariable(), mutant, 1l);
	}

}
