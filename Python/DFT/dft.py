# -*- coding: utf-8 -*-
"""
Alex Marchenko (March 2015)

A starting point for building one's own DFT code in Python. 
This module should not be run directly, rather it should be
imported and then the hydrogen function may be run.

Note
    There are a large number of simplifications/explanations 
    giving in the presentation accompanying this code.
"""


def hydrogen(g=30, r=4):
    """
    Computes the ground state energy of a hydrogen atom using 
    a finite difference grid and the Hamiltonian of Hohenberg and Kohn.
    
    Args
        g (int): Grid spacing
        r (float): Positive and negative box size (1D)
        
    Returns
        energy (float): Ground state energy (in Hartrees)
        density (numpy.ndarray): Ground state density
        p (numpy.ndarray): Discretized grid (1D)
    """
    # First build our finite difference grid
    g3 = g**3
    p = np.linspace(-r, r, g)
    X, Y, Z = np.meshgrid(p, p, p)
    h = p[1] - p[0]
    Xf = X.flatten()
    Yf = Y.flatten()
    Zf = Z.flatten()
    
    # Compute the (external) potential  
    rmag = np.sqrt(Xf**2 + Yf**2 + Zf**2)
    v_ext = -1 / rmag
    
    # Build the Laplacian
    e = np.ones(g)
    cfd = np.array([e, -2 * e, e])
    diags = np.array([-1, 0, 1])
    Ls = spdiags(cfd, diags, g, g) / h**2
    I = eye(g)
    
    # All of the kron() statements in a single line
    L = kron(kron(Ls, I), I) + kron(kron(I, Ls), I) + kron(kron(I, I), Ls) 
    
    # Build the Hamiltonian
    T = -0.5 * L
    V = spdiags(v_ext, 0, g3, g3)
    H = T + V
    
    # Solve the eigenvalue problem
    eig, psi = eigsh(H, 1, which = 'SA')
    
    # Return energy and density
    psi = psi[:, 0] / h**(3/2)
    psi = psi.reshape(psi.shape[0], 1)
    rho = psi**2
    nrg = eig[0].real
    return nrg, rho, p
