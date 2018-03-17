package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;

import java.util.concurrent.Callable;


public class AORSubMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyMathFunctions() {	
		createTesteeWith(AORSubMutator.AORSUB_MUTATOR);
	}
	private static class HasIAdd implements Callable<String> {
		private int i;

		HasIAdd(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i++;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerAdditionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasIAdd.class);
		assertMutantCallableReturns(new HasIAdd(1), mutant, "0");
		assertMutantCallableReturns(new HasIAdd(20), mutant, "19");
	}
	private static class HasIMul implements Callable<String> {
		private int i;

		HasIMul(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerMulticationWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasIMul.class);
		assertMutantCallableReturns(new HasIMul(2), mutant, "0");
		assertMutantCallableReturns(new HasIMul(20), mutant, "18");
	}
	private static class HasIDiv implements Callable<String> {
		private int i;

		HasIDiv(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerDivisionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasIDiv.class);
		assertMutantCallableReturns(new HasIDiv(2), mutant, "0");
		assertMutantCallableReturns(new HasIDiv(20), mutant, "18");
	}
	private static class HasIRem implements Callable<String> {
		private int i;

		HasIRem(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerModulusWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasIRem.class);
		assertMutantCallableReturns(new HasIRem(2), mutant, "0");
		assertMutantCallableReturns(new HasIRem(20), mutant, "18");
	}

	//long

	private static class HasLAdd implements Callable<String> {
		private long i;

		HasLAdd(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i++;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongAdditionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasLAdd.class);
		assertMutantCallableReturns(new HasLAdd(1), mutant, "0");
		assertMutantCallableReturns(new HasLAdd(20), mutant, "19");
	}
	private static class HasLMul implements Callable<String> {
		private long i;

		HasLMul(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongMulticationWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasLMul.class);
		assertMutantCallableReturns(new HasLMul(2), mutant, "0");
		assertMutantCallableReturns(new HasLMul(20), mutant, "18");
	}
	private static class HasLDiv implements Callable<String> {
		private long i;

		HasLDiv(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongDivisionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasLDiv.class);
		assertMutantCallableReturns(new HasLDiv(2), mutant, "0");
		assertMutantCallableReturns(new HasLDiv(20), mutant, "18");
	}
	private static class HasLRem implements Callable<String> {
		private long i;

		HasLRem(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongModulusWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasLRem.class);
		assertMutantCallableReturns(new HasLRem(2), mutant, "0");
		assertMutantCallableReturns(new HasLRem(20), mutant, "18");
	}
	//float

	private static class HasFAdd implements Callable<String> {
		private float i;

		HasFAdd(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i++;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatAdditionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasFAdd.class);
		assertMutantCallableReturns(new HasFAdd(2), mutant, "1.0");
		assertMutantCallableReturns(new HasFAdd(20), mutant, "19.0");
	}
	private static class HasFMul implements Callable<String> {
		private float i;

		HasFMul(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatMulticationWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasFMul.class);
		assertMutantCallableReturns(new HasFMul(2), mutant, "0.0");
		assertMutantCallableReturns(new HasFMul(20), mutant, "18.0");
	}
	private static class HasFDiv implements Callable<String> {
		private float i;

		HasFDiv(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatDivisionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasFDiv.class);
		assertMutantCallableReturns(new HasFDiv(2), mutant, "0.0");
		assertMutantCallableReturns(new HasFDiv(20), mutant, "18.0");
	}
	private static class HasFRem implements Callable<String> {
		private float i;

		HasFRem(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatModulusWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasFRem.class);
		assertMutantCallableReturns(new HasFRem(4), mutant, "2.0");
		assertMutantCallableReturns(new HasFRem(20), mutant, "18.0");
	}
	//double

	private static class HasDMul implements Callable<String> {
		private double i;

		HasDMul(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleMulticationWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasDMul.class);
		assertMutantCallableReturns(new HasDMul(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDMul(20), mutant, "18.0");
	}

	private static class HasDDiv implements Callable<String> {
		private double i;

		HasDDiv(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleDivisionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasDDiv.class);
		assertMutantCallableReturns(new HasDDiv(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDDiv(20), mutant, "18.0");
	}
	private static class HasDAdd implements Callable<String> {
		private double i;

		HasDAdd(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i++;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleAdditionWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasDAdd.class);
		assertMutantCallableReturns(new HasDAdd(1), mutant, "0.0");
		assertMutantCallableReturns(new HasDAdd(20), mutant, "19.0");
	}
	private static class HasDRem implements Callable<String> {
		private double i;

		HasDRem(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleModulusWithSubtraction() throws Exception {
		final Mutant mutant = getFirstMutant(HasDRem.class);
		assertMutantCallableReturns(new HasDRem(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDRem(20), mutant, "18.0");
	}
}
