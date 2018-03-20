package org.pitest.mutationtest.engine.gregor.mutators.AOR;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;

public enum ReplaceArithmeticWithMulMutator implements MethodMutatorFactory {

  REPLACE_ARITHMETIC_WITH_MUL_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
  final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new ReplaceArithmeticWithMulVisitor(this, methodInfo, context, methodVisitor);
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

class ReplaceArithmeticWithMulVisitor extends AbstractInsnMutator {

  ReplaceArithmeticWithMulVisitor(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
            "AOR: Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
            "AOR: Replaced integer subtraction with multiplication"));

    // longs
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL,
            "AOR: Replaced long addition with multiplication"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
            "AOR: Replaced long subtraction with multiplication"));
    //float
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
            "AOR: Replaced float addition with multiplication"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
            "AOR: Replaced float subtraction with multiplication"));

    //double
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
            "AOR: Replaced double addition with multiplication"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
            "AOR: Replaced double subtraction with multiplication"));
   }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}