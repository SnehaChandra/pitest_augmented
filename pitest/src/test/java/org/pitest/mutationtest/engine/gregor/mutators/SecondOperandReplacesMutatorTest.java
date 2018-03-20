package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.AOD.SecondOperandReplacesMutator;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.MutantStarter;

import java.util.concurrent.Callable;

public class SecondOperandReplacesMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyNegs() {
		createTesteeWith(new SecondOperandReplacesMutator());
	}

	public static class HasIADD implements Callable<Integer> {

		private int member2;
		private int member1;
		private int result;

		@Override
		public Integer call() throws Exception {
			this.member1 = 1;
			this.member2 = 2;
			result = member1 + member2;
			return result;
		}
	}

	@Test
	public void shouldCnangeIntegerAdd() throws Exception {
		final Mutant mutant = getFirstMutant(HasIADD.class);
		assertMutantCallableReturns(new MutantStarter<Integer>(HasIADD.class), mutant, 2);
	}

	public static class HasLADD implements Callable<Long> {

		private long member2;
		private long member1;
		private long result;

		@Override
		public Long call() throws Exception {
			this.member1 = 1;
			this.member2 = 2l;
			result = member1 + member2;
			return result;
		}
	}

	@Test
	public void shouldCnangeLongAdd() throws Exception {
		final Mutant mutant = getFirstMutant(HasLADD.class);
		assertMutantCallableReturns(new MutantStarter<Long>(HasLADD.class), mutant, 2l);
	}

	
	public static class HasDADD implements Callable<Double> {

		private double member2;
		private double member1;
		private double result;

		@Override
		public Double call() throws Exception {
			this.member1 = 1;
			this.member2 = 2d;
			result = member1 + member2;
			return result;
		}
	}

	@Test
	public void shouldCnangeDoubleAdd() throws Exception {
		final Mutant mutant = getFirstMutant(HasDADD.class);
		assertMutantCallableReturns(new MutantStarter<Double>(HasDADD.class), mutant, 2d);
	}

	public static class HasFADD implements Callable<Float> {

		private float member2;
		private float member1;
		private float result;

		@Override
		public Float call() throws Exception {
			this.member1 = 1f;
			this.member2 = 2f;
			result = member1 + member2;
			return result;
		}
	}

	@Test
	public void shouldCnangeFloatAdd() throws Exception {
		final Mutant mutant = getFirstMutant(HasFADD.class);
		assertMutantCallableReturns(new MutantStarter<Float>(HasFADD.class), mutant, 2f);
	}

	
	public static class HasISUB implements Callable<Integer> {
		private int member2;
		private int member1;
		private int result;
		@Override
		public Integer call() throws Exception {
			this.member1 = 1;
			this.member2 = 2;
			result = member1 - member2;
			return result;
		}
	}

	@Test
	public void shouldCnangeIntegerSub() throws Exception {
		final Mutant mutant = getFirstMutant(HasISUB.class);
		assertMutantCallableReturns(new MutantStarter<Integer>(HasISUB.class), mutant, 2);
	}

	public static class HasLMUL implements Callable<Long> {
		private long member2;
		private long member1;
		private long result;
		@Override
		public Long call() throws Exception {
			this.member1 = 1;
			this.member2 = 2;
			result = member1 * member2;
			System.out.println(result);
			return result;
		}
	}

	@Test
	public void shouldCnangeLongMUL() throws Exception {
		final Mutant mutant = getFirstMutant(HasLMUL.class);
		assertMutantCallableReturns(new MutantStarter<Long>(HasLMUL.class), mutant, 2l);
	}

	public static class HasLDiv implements Callable<Long> {
		private long member2;
		private long member1;
		private long result;
		@Override
		public Long call() throws Exception {
			this.member1 = 1;
			this.member2 = 2;
			result = member1 / member2;
			System.out.println(result);
			return result;
		}
	}

	@Test
	public void shouldCnangeLongDiv() throws Exception {
		final Mutant mutant = getFirstMutant(HasLDiv.class);
		assertMutantCallableReturns(new MutantStarter<Long>(HasLDiv.class), mutant, 2l);
	}

	public static class HasDDiv implements Callable<Double> {
		private double member2;
		private double member1;
		private double result;
		@Override
		public Double call() throws Exception {
			this.member1 = 1;
			this.member2 = 2;
			result = member1 / member2;
			System.out.println(result);
			return result;
		}
	}

	@Test
	public void shouldCnangeDoubleDiv() throws Exception {
		final Mutant mutant = getFirstMutant(HasDDiv.class);
		assertMutantCallableReturns(new MutantStarter<Double>(HasDDiv.class), mutant, 2d);
	}

	public static class HasIMUL implements Callable<Integer> {
		private int member2;
		private int member1;
		private int result;
		@Override
		public Integer call() throws Exception {
			this.member1 = 1;
			this.member2 = 2;
			result = member1 * member2;
			System.out.println(result);
			return result;
		}
	}

	@Test
	public void shouldCnangeIntegerMul() throws Exception {
		final Mutant mutant = getFirstMutant(HasIMUL.class);
		assertMutantCallableReturns(new MutantStarter<Integer>(HasIMUL.class), mutant, 2);
	}

}
