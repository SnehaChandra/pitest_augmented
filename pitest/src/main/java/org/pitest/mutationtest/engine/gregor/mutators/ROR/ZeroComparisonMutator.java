package org.pitest.mutationtest.engine.gregor.mutators.ROR;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

import java.util.HashMap;
import java.util.Map;

public enum ZeroComparisonMutator implements MethodMutatorFactory {

  ZERO_COMPARISON_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new ZeroComparisonVisitor(this, context, methodVisitor);
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

class ZeroComparisonVisitor extends AbstractJumpMutator {

  ZeroComparisonVisitor(final MethodMutatorFactory factory,
                         final MutationContext context, final MethodVisitor delegateMethodVisitor) {
        super(factory, context, delegateMethodVisitor);
  }

  private static final Map<Integer, Substitution> MUTATIONS = new HashMap<Integer, Substitution>();
  private static final String DESCRIPTION = "ROR: changed relational operators that compare an integer with zero";

  static {
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFEQ, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGE, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGT, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLE, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLT, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFNE, DESCRIPTION));

  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
