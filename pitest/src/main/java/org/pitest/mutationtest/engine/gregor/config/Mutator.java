/*
 * Copyright 2010 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.mutationtest.engine.gregor.config;

import org.pitest.functional.FCollection;
import org.pitest.functional.prelude.Prelude;
import org.pitest.help.Help;
import org.pitest.help.PitHelpError;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;

import org.pitest.mutationtest.engine.gregor.mutators.AOD.FirstOperandMutator;
import org.pitest.mutationtest.engine.gregor.mutators.AOD.SecondOperandMutator;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithAddMutator;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithDivMutator;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithMulMutator;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithRemMutator;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithSubMutator;

import org.pitest.mutationtest.engine.gregor.mutators.ArgumentPropagationMutator;
import org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.CRCRMutateConstantToAddOne;
import org.pitest.mutationtest.engine.gregor.mutators.CRCRMutateConstantToSubOne;
import org.pitest.mutationtest.engine.gregor.mutators.CRCRMutateConstantWith0;
import org.pitest.mutationtest.engine.gregor.mutators.CRCRMutateConstantWith1;
import org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator;
import org.pitest.mutationtest.engine.gregor.mutators.ConstructorCallMutator;
import org.pitest.mutationtest.engine.gregor.mutators.EmptyObjectReturnValsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.InlineConstantMutator;
import org.pitest.mutationtest.engine.gregor.mutators.InvertNegsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.MathMutator;
import org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.NegateVariableMutator;
import org.pitest.mutationtest.engine.gregor.mutators.NonVoidMethodCallMutator;
import org.pitest.mutationtest.engine.gregor.mutators.NullPointerFixingMutator;
import org.pitest.mutationtest.engine.gregor.mutators.NullReturnValsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.PrimitiveReturnsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorACMP;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPEQ;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPGE;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPGT;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPLE;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPLT;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPNE;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFEQ;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFGE;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFGT;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFLE;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFLT;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorIFNE;
import org.pitest.mutationtest.engine.gregor.mutators.RemoveConditionalMutator;
import org.pitest.mutationtest.engine.gregor.mutators.RemoveConditionalMutator.Choice;
import org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.UOIMutator;
import org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.NakedReceiverMutator;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.RemoveIncrementsMutator;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.RemoveSwitchMutator;
import org.pitest.mutationtest.engine.gregor.mutators.experimental.SwitchMutator;

import java.util.*;
import java.util.function.Function;


public final class Mutator {

  private static final Map<String, Iterable<MethodMutatorFactory>> MUTATORS = new LinkedHashMap<>();

  static {
    /**
     * Mutators that replace arithmetic expression with operands
     */
    add("FIRST_OPERAND_VISITOR", new FirstOperandMutator());
    add("SECOND_OPERAND_REPLACES_OPERATOR", new SecondOperandMutator());

    /**
     * Mutators that replace each of the arithmetic operators with all of the others
     */
    add("REPLACE_ARITHMETIC_WITH_ADD_MUTATOR", ReplaceArithmeticWithAddMutator.REPLACE_ARITHMETIC_WITH_ADD_MUTATOR);
    add("REPLACE_ARITHMETIC_WITH_DIV_MUTATOR", ReplaceArithmeticWithDivMutator.REPLACE_ARITHMETIC_WITH_DIV_MUTATOR);
    add("REPLACE_ARITHMETIC_WITH_MUL_MUTATOR", ReplaceArithmeticWithMulMutator.REPLACE_ARITHMETIC_WITH_MUL_MUTATOR);
    add("REPLACE_ARITHMETIC_WITH_SUB_MUTATOR", ReplaceArithmeticWithSubMutator.REPLACE_ARITHMETIC_WITH_SUB_MUTATOR);
    add("REPLACE_ARITHMETIC_WITH_REM_MUTATOR", ReplaceArithmeticWithRemMutator.REPLACE_ARITHMETIC_WITH_REM_MUTATOR);

    add("CRCR_VARIABLE_MUTATOR_TO_ADD_ONE", new CRCRMutateConstantToAddOne());
    add("CRCR_VARIABLE_MUTATOR_TO_SUB_ONE", new CRCRMutateConstantToSubOne());
    add("CRCR_VARIABLE_MUTATOR_TO_ZERO", new CRCRMutateConstantWith0());
    add("CRC_VARIABLE_MUTATOR_TO_ONE", new CRCRMutateConstantWith1());
    add("NEGATE_VARIABLE_MUTATOR", new NegateVariableMutator());
    add("ROR_MUTATOR_ACMP", RORMutatorACMP.ROR_MUTATOR_ACMP);
    add("ROR_MUTATOR_ICMPEQ", RORMutatorICMPEQ.ROR_MUTATOR_ICMPEQ);
    add("ROR_MUTATOR_ICMPGE", RORMutatorICMPGE.ROR_MUTATOR_ICMPGE);
    add("ROR_MUTATOR_ICMPGT", RORMutatorICMPGT.ROR_MUTATOR_ICMPGT);
    add("ROR_MUTATOR_ICMPLE", RORMutatorICMPLE.ROR_MUTATOR_ICMPLE);
    add("ROR_MUTATOR_ICMPLT", RORMutatorICMPLT.ROR_MUTATOR_ICMPLT);
    add("ROR_MUTATOR_ICMPNE", RORMutatorICMPNE.ROR_MUTATOR_ICMPNE);
    add("ROR_MUTATOR_IFEQ", RORMutatorIFEQ.ROR_MUTATOR_IFEQ);
    add("ROR_MUTATOR_IFGE", RORMutatorIFGE.ROR_MUTATOR_IFGE);
    add("ROR_MUTATOR_IFGT", RORMutatorIFGT.ROR_MUTATOR_IFGT);
    add("ROR_MUTATOR_IFLE", RORMutatorIFLE.ROR_MUTATOR_IFLE);
    add("ROR_MUTATOR_IFLT", RORMutatorIFLT.ROR_MUTATOR_IFLT);
    add("ROR_MUTATOR_IFNE", RORMutatorIFNE.ROR_MUTATOR_IFNE);


    add("UOI_REVERSE", new UOIMutator(UOIMutator.MutantType.REVERSE));
    add("UOI_REMOVE", new UOIMutator(UOIMutator.MutantType.REMOVE));
    add("UOI_INCREMENT", new UOIMutator(UOIMutator.MutantType.INCREMENT));
    add("UOI_DECREMENT", new UOIMutator(UOIMutator.MutantType.DECREMENT));

    add("M1_NULL_POINTER_FIXING_MUTATOR", new NullPointerFixingMutator());


    /**
     * Default mutator that inverts the negation of integer and floating point
     * numbers.
     */
    add("INVERT_NEGS", InvertNegsMutator.INVERT_NEGS_MUTATOR);

    /**
     * Default mutator that mutates the return values of methods.
     */
    add("RETURN_VALS", ReturnValsMutator.RETURN_VALS_MUTATOR);

    /**
     * Optional mutator that mutates integer and floating point inline
     * constants.
     */
    add("INLINE_CONSTS", new InlineConstantMutator());

    /**
     * Default mutator that mutates binary arithmetic operations.
     */
    add("MATH", MathMutator.MATH_MUTATOR);

    /**
     * Default mutator that removes method calls to void methods.
     *
     */
    add("VOID_METHOD_CALLS", VoidMethodCallMutator.VOID_METHOD_CALL_MUTATOR);

    /**
     * Default mutator that negates conditionals.
     */
    add("NEGATE_CONDITIONALS",
        NegateConditionalsMutator.NEGATE_CONDITIONALS_MUTATOR);

    /**
     * Default mutator that replaces the relational operators with their
     * boundary counterpart.
     */
    add("CONDITIONALS_BOUNDARY",
        ConditionalsBoundaryMutator.CONDITIONALS_BOUNDARY_MUTATOR);

    /**
     * Default mutator that mutates increments, decrements and assignment
     * increments and decrements of local variables.
     */
    add("INCREMENTS", IncrementsMutator.INCREMENTS_MUTATOR);

    /**
     * Optional mutator that removes local variable increments.
     */

    add("REMOVE_INCREMENTS", RemoveIncrementsMutator.REMOVE_INCREMENTS_MUTATOR);

    /**
     * Optional mutator that removes method calls to non void methods.
     */
    add("NON_VOID_METHOD_CALLS",
        NonVoidMethodCallMutator.NON_VOID_METHOD_CALL_MUTATOR);

    /**
     * Optional mutator that replaces constructor calls with null values.
     */
    add("CONSTRUCTOR_CALLS", ConstructorCallMutator.CONSTRUCTOR_CALL_MUTATOR);

    /**
     * Removes conditional statements so that guarded statements always execute
     * The EQUAL version ignores LT,LE,GT,GE, which is the default behaviour,
     * ORDER version mutates only those.
     */

    add("REMOVE_CONDITIONALS_EQ_IF", new RemoveConditionalMutator(Choice.EQUAL,
        true));
    add("REMOVE_CONDITIONALS_EQ_ELSE", new RemoveConditionalMutator(
        Choice.EQUAL, false));
    add("REMOVE_CONDITIONALS_ORD_IF", new RemoveConditionalMutator(
        Choice.ORDER, true));
    add("REMOVE_CONDITIONALS_ORD_ELSE", new RemoveConditionalMutator(
        Choice.ORDER, false));
    addGroup("REMOVE_CONDITIONALS", RemoveConditionalMutator.makeMutators());

    add("TRUE_RETURNS", BooleanTrueReturnValsMutator.BOOLEAN_TRUE_RETURN);
    add("FALSE_RETURNS", BooleanFalseReturnValsMutator.BOOLEAN_FALSE_RETURN);
    add("PRIMITIVE_RETURNS", PrimitiveReturnsMutator.PRIMITIVE_RETURN_VALS_MUTATOR);
    add("EMPTY_RETURNS", EmptyObjectReturnValsMutator.EMPTY_RETURN_VALUES);
    add("NULL_RETURNS", NullReturnValsMutator.NULL_RETURN_VALUES);
    addGroup("RETURNS", betterReturns());

    /**
     * Experimental mutator that removed assignments to member variables.
     */
    add("EXPERIMENTAL_MEMBER_VARIABLE",
        new org.pitest.mutationtest.engine.gregor.mutators.experimental.MemberVariableMutator());

    /**
     * Experimental mutator that swaps labels in switch statements
     */
    add("EXPERIMENTAL_SWITCH",
        new org.pitest.mutationtest.engine.gregor.mutators.experimental.SwitchMutator());

    /**
     * Experimental mutator that replaces method call with one of its parameters
     * of matching type
     */
    add("EXPERIMENTAL_ARGUMENT_PROPAGATION",
        ArgumentPropagationMutator.ARGUMENT_PROPAGATION_MUTATOR);

    /**
     * Experimental mutator that replaces method call with this
     */
    add("EXPERIMENTAL_NAKED_RECEIVER", NakedReceiverMutator.NAKED_RECEIVER);

    addGroup("REMOVE_SWITCH", RemoveSwitchMutator.makeMutators());
    addGroup("DEFAULTS", defaults());
    addGroup("STRONGER", stronger());
    addGroup("ALL", all());
    addGroup("NEW_DEFAULTS", newDefaults());
    addGroup("UOI", uoi());
  }

  public static Collection<MethodMutatorFactory> all() {
    return fromStrings(MUTATORS.keySet());
  }

  private static Collection<MethodMutatorFactory> stronger() {
    return combine(
        defaults(),
        group(new RemoveConditionalMutator(Choice.EQUAL, false),
            new SwitchMutator()));
  }

  private static Collection<MethodMutatorFactory> combine(
      Collection<MethodMutatorFactory> a, Collection<MethodMutatorFactory> b) {
    final List<MethodMutatorFactory> l = new ArrayList<>(a);
    l.addAll(b);
    return l;
  }

  /**
   * Default set of mutators - designed to provide balance between strength and
   * performance
   */
  public static Collection<MethodMutatorFactory> defaults() {
    return group(InvertNegsMutator.INVERT_NEGS_MUTATOR,
            ReturnValsMutator.RETURN_VALS_MUTATOR, MathMutator.MATH_MUTATOR,
            VoidMethodCallMutator.VOID_METHOD_CALL_MUTATOR,
            NegateConditionalsMutator.NEGATE_CONDITIONALS_MUTATOR,
            ConditionalsBoundaryMutator.CONDITIONALS_BOUNDARY_MUTATOR,
            IncrementsMutator.INCREMENTS_MUTATOR,
            ReplaceArithmeticWithAddMutator.REPLACE_ARITHMETIC_WITH_ADD_MUTATOR,
            ReplaceArithmeticWithDivMutator.REPLACE_ARITHMETIC_WITH_DIV_MUTATOR,
            ReplaceArithmeticWithMulMutator.REPLACE_ARITHMETIC_WITH_MUL_MUTATOR,
            ReplaceArithmeticWithSubMutator.REPLACE_ARITHMETIC_WITH_SUB_MUTATOR,
            ReplaceArithmeticWithRemMutator.REPLACE_ARITHMETIC_WITH_REM_MUTATOR,
            new SecondOperandMutator(),
            new FirstOperandMutator(),
            new CRCRMutateConstantToAddOne(),
            new CRCRMutateConstantToSubOne(),
            new CRCRMutateConstantWith0(),
            new CRCRMutateConstantWith1(),
            new NegateVariableMutator(),
            new NullPointerFixingMutator(),
            RORMutatorACMP.ROR_MUTATOR_ACMP,
            RORMutatorICMPEQ.ROR_MUTATOR_ICMPEQ,
            RORMutatorICMPGE.ROR_MUTATOR_ICMPGE,
            RORMutatorICMPGT.ROR_MUTATOR_ICMPGT,
            RORMutatorICMPLE.ROR_MUTATOR_ICMPLE,
            RORMutatorICMPLT.ROR_MUTATOR_ICMPLT,
            RORMutatorICMPNE.ROR_MUTATOR_ICMPNE,
            RORMutatorIFEQ.ROR_MUTATOR_IFEQ,
            RORMutatorIFGE.ROR_MUTATOR_IFGE,
            RORMutatorIFGT.ROR_MUTATOR_IFGT,
            RORMutatorIFLE.ROR_MUTATOR_IFLE,
            RORMutatorIFLT.ROR_MUTATOR_IFLT,
            RORMutatorIFNE.ROR_MUTATOR_IFNE,
            new UOIMutator(UOIMutator.MutantType.REVERSE),
            new UOIMutator(UOIMutator.MutantType.REMOVE),
            new UOIMutator(UOIMutator.MutantType.INCREMENT),
            new UOIMutator(UOIMutator.MutantType.DECREMENT));
  }

  /**
   * Proposed new defaults - replaced the RETURN_VALS mutator with the new more stable set
   */
  public static Collection<MethodMutatorFactory> newDefaults() {
    return combine(group(InvertNegsMutator.INVERT_NEGS_MUTATOR,
        MathMutator.MATH_MUTATOR,
        VoidMethodCallMutator.VOID_METHOD_CALL_MUTATOR,
        NegateConditionalsMutator.NEGATE_CONDITIONALS_MUTATOR,
        ConditionalsBoundaryMutator.CONDITIONALS_BOUNDARY_MUTATOR,
        IncrementsMutator.INCREMENTS_MUTATOR), betterReturns());
  }

  public static Collection<MethodMutatorFactory> uoi() {
    return group(new UOIMutator(UOIMutator.MutantType.REVERSE),
            new UOIMutator(UOIMutator.MutantType.REMOVE),
            new UOIMutator(UOIMutator.MutantType.INCREMENT),
            new UOIMutator(UOIMutator.MutantType.DECREMENT));
  }

  public static Collection<MethodMutatorFactory> betterReturns() {
    return group(BooleanTrueReturnValsMutator.BOOLEAN_TRUE_RETURN,
        BooleanFalseReturnValsMutator.BOOLEAN_FALSE_RETURN,
        PrimitiveReturnsMutator.PRIMITIVE_RETURN_VALS_MUTATOR,
        EmptyObjectReturnValsMutator.EMPTY_RETURN_VALUES,
        NullReturnValsMutator.NULL_RETURN_VALUES);
  }

  private static Collection<MethodMutatorFactory> group(
      final MethodMutatorFactory... ms) {
    return Arrays.asList(ms);
  }

  public static Collection<MethodMutatorFactory> byName(final String name) {
    return FCollection.map(MUTATORS.get(name),
        Prelude.id(MethodMutatorFactory.class));
  }

  private static void add(final String key, final MethodMutatorFactory value) {
    MUTATORS.put(key, Collections.singleton(value));
  }

  private static void addGroup(final String key,
      final Iterable<MethodMutatorFactory> value) {
    MUTATORS.put(key, value);
  }

  public static Collection<MethodMutatorFactory> fromStrings(
      final Collection<String> names) {
    final Set<MethodMutatorFactory> unique = new TreeSet<>(
        compareId());

    FCollection.flatMapTo(names, fromString(), unique);
    return unique;
  }

  private static Comparator<? super MethodMutatorFactory> compareId() {
    return (o1, o2) -> o1.getGloballyUniqueId().compareTo(o2.getGloballyUniqueId());
  }

  private static Function<String, Iterable<MethodMutatorFactory>> fromString() {
    return a -> {
      final Iterable<MethodMutatorFactory> i = MUTATORS.get(a);
      if (i == null) {
        throw new PitHelpError(Help.UNKNOWN_MUTATOR, a);
      }
      return i;
    };
  }
 /** private static Collection<MethodMutatorFactory> custom() {
    return combine(MethodNameMutator.makeMutators(),
            combine(group(new NullPointerFixingMutator()),MethodOverloadingMutator.makeMutators()));
  }**/

}
