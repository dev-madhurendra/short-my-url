import React from 'react';
import { Meta, StoryObj } from '@storybook/react';
import MuiTypography from './index'; 
const meta: Meta<typeof MuiTypography> = {
  title: 'atoms/Typography',
  component: MuiTypography,
  argTypes: {
    variant: {
      control: 'select',
      options: ['h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'subtitle1', 'subtitle2', 'body1', 'body2'],
    },
    text: { control: 'text' },
  },
};

export default meta;

export const Primary: StoryObj<typeof MuiTypography> = {
  args: {
    text: 'Hi Admin',
    variant: 'h1',
  },
};

export const Secondary: StoryObj<typeof MuiTypography> = {
  args: {
    text: 'Hello User',
    variant: 'subtitle1',
  },
};

