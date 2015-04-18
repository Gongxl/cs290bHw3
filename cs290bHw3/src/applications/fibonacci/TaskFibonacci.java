/*
 * The MIT License
 *
 * Copyright 2015 peter.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR ONE PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package applications.fibonacci;

import api.ReturnSubtasks;
import api.ReturnValue;
import api.Task;
import api.TaskRecursive;
import java.util.ArrayList;
import java.util.List;

/**
 * Compute the nth Fibonacci number.
 * @author Peter Cappello
 */
public class TaskFibonacci extends TaskRecursive<Integer>
{ 
    final private int n;
            
    public TaskFibonacci( int n ) 
    { 
        if ( n < 0 )
        {
            throw new IllegalArgumentException( "number " + n + " is < 0.");
        }
        this.n = n; 
    }

    @Override
    public boolean isAtomic() { return n < 2; }

    @Override
    public ReturnValue<Integer> solve() { return new ReturnValue<>( this, n ); }

    @Override
    public ReturnSubtasks divideAndConquer() 
    {
        List<Task> subtasks = new ArrayList<>();
        subtasks.add( new TaskFibonacci( n - 2 ) );
        subtasks.add( new TaskFibonacci( n - 1 ) );
        
        return new ReturnSubtasks( new SumIntegers(), subtasks ); 
    }
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( super.toString() );
        stringBuilder.append( getClass() );
        stringBuilder.append( ": number: " );
        stringBuilder.append( n );
        return stringBuilder.toString();
    }
}
