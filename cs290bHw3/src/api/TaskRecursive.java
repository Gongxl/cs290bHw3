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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package api;

import system.Return;

/**
 *
 * @author Peter Cappello
 * @param <T> type of the solution to this recursive problem.
 */
abstract public class TaskRecursive<T> extends Task
{    
    @Override
    public Return call() { return isAtomic() ? solve() : decompose(); }
    
    abstract public boolean isAtomic();
    
    abstract public ReturnValue<T> solve();
    
    abstract public ReturnSubtasks decompose();
    
//    /**
//     * Give SpaceProxy these tasks: This is NOT a remote method.
//     * @param compose
//     * @param tasks
//     */
//    protected void compute( TaskCompose compose, Task[] tasks )
//    {
//        compose.composeId( this.composeId() );
//        System.out.println("TaskRecursive.compute: TaskId: " + id() + " composeId: " + this.composeId() + " tasks.length: " + tasks.length);
//        try { space.compute( compose, tasks ); } catch ( RemoteException ignore ){}
//    }
}