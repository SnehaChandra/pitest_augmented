package org.pitest.mutationtest.engine.gregor.mutators.AOD;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.*;

import java.util.HashMap;
import java.util.Map;

public enum OperandReplacesArithmeticMutator implements MethodMutatorFactory {

    OPERAND_REPLACES_ARITHMETIC_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
                                final MethodVisitor methodVisitor) {
        return new OperandReplacesArithmeticVisitor(this, methodInfo, context, methodVisitor);
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

class OperandReplacesArithmeticVisitor extends AbstractInsnMutator {
    private final MutationContext context;

    OperandReplacesArithmeticVisitor(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
                     final MethodVisitor writer) {
        super(factory, methodInfo, context, writer);
        this.context = context;
        }

    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

    static {
        MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.POP, "AOD: Integer Mul with first operand"));
        MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.POP2, "AOD: Long Mul with first operand"));
        MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.POP, "AOD: Float Mul with first operand"));
        MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.POP2, "AOD: Double Mul with first operand"));

        MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.POP, "AOD: Integer div with first operand"));
        MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.POP2, "AOD: Long div with first operand"));
        MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.POP, "AOD: Float div with first operand"));
        MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.POP2, "AOD: Double div with first operand"));

        MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.POP, "AOD: Integer ADD with first operand"));
        MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.POP2, "AOD: Long ADD with first operand"));
        MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.POP, "AOD: Float ADD with first operand"));
        MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.POP2, "AOD: Double ADD with first operand"));

        MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.POP, "AOD: Integer SUB with first operand"));
        MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.POP2, "AOD: Long SUB with first operand"));
        MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.POP, "AOD: Float SUB with first operand"));
        MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.POP2, "AOD: Double SUB with first operand"));

    }


    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
        return MUTATIONS;
        }

}
