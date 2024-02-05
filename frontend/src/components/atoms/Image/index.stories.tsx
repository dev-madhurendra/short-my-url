import React from "react";
import ImageComponent from "./index";
import { Meta, StoryObj } from "@storybook/react";
import facebook from '../../../../public/assets/images/facebook.svg';
import graph from '../../../../public/assets/images/graph.svg';
import rupee from '../../../../public/assets/images/rupee.svg';

export default {
  title: 'atoms/Image',
  component: ImageComponent,
} as Meta<typeof ImageComponent>;

export const Facebook: StoryObj<typeof ImageComponent> = {
  args: {
    src: facebook,
    height: '60px',
    width: '60px',
  }
};

export const Graph: StoryObj<typeof ImageComponent> = {
  args: {
    src: graph,
    height: '60px',
    width: '60px',
  }
};

export const Rupee: StoryObj<typeof ImageComponent> = {
  args: {
    src: rupee,
    height: '60px',
    width: '60px',
  }
};
