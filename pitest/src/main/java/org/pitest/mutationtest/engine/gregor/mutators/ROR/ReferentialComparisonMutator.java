package org.pitest.mutationtest.engine.gregor.mutators.ROR;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

import java.util.HashMap;
import java.util.Map;

public enum ReferentialComparisonMutator implements MethodMutatorFactory {

  REFERENTIAL_COMPARISON_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new ReferentialComparisonVisitor(this, context, methodVisitor);
  }

  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

  @Override
  public String getName() {
    return name();
  }

}

class ReferentialComparisonVisitor extends AbstractJumpMutator {

  ReferentialComparisonVisitor(final MethodMutatorFactory factory,
                         final MutationContext context, final MethodVisitor delegateMethodVisitor) {
        super(factory, context, delegateMethodVisitor);
  }

  private static final Map<Integer, Substitution> MUTATIONS = new HashMap<Integer, Substitution>();
  private static final String DESCRIPTION = "ROR: changed relational operators that compare references";

  static {
        MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE, DESCRIPTION));
        MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ, DESCRIPTION));
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
