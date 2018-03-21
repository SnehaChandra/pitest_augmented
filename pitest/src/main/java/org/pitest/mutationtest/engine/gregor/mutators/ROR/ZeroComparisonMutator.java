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

  static {
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFEQ, "ROR: changed less than zero comparison to equals operator"));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFEQ, "ROR: changed less than or equals zero comparison to equals operator"));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFEQ, "ROR: changed greater than zero comparison to equals operator"));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFEQ, "ROR: changed greater than or equals zero comparison to equals operator"));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGE, "ROR: changed equals zero comparison to greater than or equals operator"));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGE, "ROR: changed greater than zero comparison to greater than or equals operator"));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGE, "ROR: changed not equals zero comparison to greater than or equals operator"));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGT, "ROR: changed equals zero comparison to greater than operator"));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGT, "ROR: changed greater than zero comparison to greater than operator"));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGT, "ROR: changed not equals zero comparison to greater than operator"));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLE, "ROR: changed equals zero comparison to less than or equals operator"));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLE, "ROR: changed less than zero comparison to less than or equals operator"));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLE, "ROR: changed not equals zero comparison to less than or equals operator"));

    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLT, "ROR: changed equals zero comparison to less than operator"));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLT, "ROR: changed less than or equals zero comparison to less than operator"));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLT, "ROR: changed not equals zero comparison to less than operator"));

    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFNE, "ROR: changed less than zero comparison to not equals operator"));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFNE, "ROR: changed less than or equals zero comparison to not equals operator"));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFNE, "ROR: changed greater than zero comparison to not equals operator"));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFNE, "ROR: changed greater than or equals zero comparison to not equals operator"));

  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
