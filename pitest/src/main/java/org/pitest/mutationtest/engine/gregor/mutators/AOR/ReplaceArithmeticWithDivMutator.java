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

public enum ReplaceArithmeticWithDivMutator implements MethodMutatorFactory {

  REPLACE_ARITHMETIC_WITH_DIV_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
  final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new ReplaceArithmeticWithDivVisitor(this, methodInfo, context, methodVisitor);
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

class ReplaceArithmeticWithDivVisitor extends AbstractInsnMutator {

  ReplaceArithmeticWithDivVisitor(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
            "AOR: Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
            "AOR: Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IDIV,
            "AOR: Replaced integer modulus with division"));
    // longs
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV,
            "AOR: Replaced long addition with division"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LDIV,
            "AOR: Replaced long subtraction with division"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LDIV,
            "AOR: Replaced long modulus with division"));
    //float
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
            "AOR: Replaced float addition with division"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
            "AOR: Replaced float subtraction with division"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FDIV,
            "AOR: Replaced float modulus with division"));
    // longs
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
            "AOR: Replaced double addition with division"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
            "AOR: Replaced double subtraction with division"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DDIV,
            "AOR: Replaced double modulus with division"));
  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}