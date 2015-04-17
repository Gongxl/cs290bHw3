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
package clients;

import api.Task;
import applications.fibonacci.TaskFibonacci;
import java.rmi.RemoteException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Peter Cappello
 */
public class ClientFibonacci extends Client<Integer>
{
    // configure application
    static private final int N = 16; // F(16) = 987
    static private final int NUM_COMPUTERS = 2;
    static private final Task TASK = new TaskFibonacci( N );
    static private       Client client() throws RemoteException { return new ClientFibonacci(); }
    
    public ClientFibonacci() throws RemoteException { super( "Fibonacci Number" ); }

    public static void main( String[] args ) throws Exception
    {  
        Client.runClient( client(), NUM_COMPUTERS, TASK );
    }
    
    @Override
    JLabel getLabel( Integer returnValue ) 
    {
        return new JLabel( "    The " + N +  "th Fibonacci number is " + returnValue + "    ", SwingConstants.CENTER) ;
    }
}
