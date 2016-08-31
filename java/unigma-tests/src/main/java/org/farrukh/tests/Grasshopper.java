/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.tests;

public class Grasshopper {


    public static class TreeNode {
        boolean visited;
        TreeNode left;
        TreeNode right;

        TreeNode(boolean visited) {
            this.visited = visited;
        }
    }

    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     *
     * @param n        Number of leaves in row.
     * @param position
     */

    private TreeNode row = new TreeNode(false);

    public Grasshopper(int n, int position) {
        for (int i = 0; i < n; i++) {
            TreeNode newNode = new TreeNode(false);
            if(i % 2 == 0) {
                row.left = newNode;
            } else {
                row.right = newNode;
            }
        }
    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        visit(row);
    }

    public void visit(TreeNode row) {
        if(row != null) {
            visit(row.left);
            row.visited = true;
            visit(row);
        }
    }


    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
    }

    /**
     * Return the leaf number that grasshopper is feeding on right now.
     *
     * @return Leaf number that grasshopper is feeding on right now.
     */
    public int whereAmI() {
        return -1;
    }

    public static void main(String[] args) {
        Grasshopper g = new Grasshopper(5, 2);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());
    }
}
