/*
 * Copyright 2017 Naif Alatrash
 *
 */
package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFEQ;

import java.util.concurrent.Callable;

public class RORMutatorIFEQTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateROR() {
		createTesteeWith(RORMutatorIFEQ.ROR_MUTATOR_IFEQ);
	}

	  private static class HasIFLE implements Callable<String> {
	    private final int i;

	    HasIFLE(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      if (this.i > 0) {
	        return "was > zero";
	      } else {
	        return "was <= zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIFLEwithILT() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIFLE.class);
	    assertMutantCallableReturns(new HasIFLE(1), mutant, "was > zero");
	    assertMutantCallableReturns(new HasIFLE(-1), mutant, "was > zero");
	    assertMutantCallableReturns(new HasIFLE(0), mutant, "was <= zero");
	  }

	  private static class HasIFGE implements Callable<String> {
	    private final int i;

	    HasIFGE(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      if (this.i < 0) {
	        return "was < zero";
	      } else {
	        return "was >= zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIFGEwithIFGT() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIFGE.class);
	    assertMutantCallableReturns(new HasIFGE(-1), mutant, "was < zero");
	    assertMutantCallableReturns(new HasIFGE(1), mutant, "was < zero");
	    assertMutantCallableReturns(new HasIFGE(0), mutant, "was >= zero");
	  }

	  private static class HasIFGT implements Callable<String> {
	    private final int i;

	    HasIFGT(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      if (this.i == 0) {
	        return "was <= zero";
	      } else {
	        return "was > zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIFGTwithIFGE() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIFGT.class);
	    assertMutantCallableReturns(new HasIFGT(-1), mutant, "was <= zero");
	    assertMutantCallableReturns(new HasIFGT(1), mutant, "was <= zero");
	    assertMutantCallableReturns(new HasIFGT(0), mutant, "was > zero");
	  }

	  private static class HasIFLT implements Callable<String> {
	    private final int i;

	    HasIFLT(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      if (this.i >= 0) {
	        return "was >= zero";
	      } else {
	        return "was < zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIFLTwithIFLE() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIFLT.class);
	    assertMutantCallableReturns(new HasIFLT(-1), mutant, "was >= zero");
	    assertMutantCallableReturns(new HasIFLT(1), mutant, "was >= zero");
	    assertMutantCallableReturns(new HasIFLT(0), mutant, "was < zero");
	  }


}
