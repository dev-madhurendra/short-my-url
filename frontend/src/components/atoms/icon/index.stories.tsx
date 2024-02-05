import React from "react";
import IconComponent from "./index";
import { Meta, StoryObj } from '@storybook/react';
import Micrsoft from '../../../../public/assets/images/microsoft.svg';
import Google from '../../../../public/assets/images/google.svg';

export default {
  title: "atoms/IconComponent",
  component: IconComponent,
} as Meta<typeof IconComponent>;

export const MicrosoftStory: StoryObj<typeof IconComponent> = {
  args: {
    height: "32px",
    width: "32px",
    src:Micrsoft ,
  },
};

export const GoogleStory: StoryObj<typeof IconComponent> = {
  args: {
    src: Google,
  },
};
